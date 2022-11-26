package com.example.proyectolomb;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectolomb.databinding.ActivityPrincipalBinding;
import com.example.proyectolomb.ui.encargado.nuevoEncargado.nuevo_encargado;
import com.example.proyectolomb.ui.home.HomeFragment;
import com.example.proyectolomb.ui.inicio.inicio;
import com.example.proyectolomb.ui.libro.crearLibro.crear_libro;
import com.example.proyectolomb.ui.libro.listarLibros.listar_libro;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Principal_activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityPrincipalBinding binding;
    ExpandableListAdapter listAdapterExpandable;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private ExpandableListView expListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


      setSupportActionBar(binding.appBarPrincipal.toolbar);
        binding.appBarPrincipal.btsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearFragmento("encargado");
            }

        });
        // Cards
        DrawerLayout drawer = binding.drawerLayout;
        crearFragmento("inicio");
        expListView = binding.expandableList;
        // Menu del navigation
        prepareListData();
        listAdapterExpandable = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapterExpandable);
        int count = listAdapterExpandable.getGroupCount();
        for ( int i = 0; i < count; i++ )
            expListView.collapseGroup(i);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                String selectedItem=listAdapterExpandable.getChild(groupPosition,(int) childPosition).toString();
                crearFragmento(selectedItem);

                return false;
            }
        });

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_listar_libros, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(listAdapterExpandable, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal_activity, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Agrega Encabezados.
        listDataHeader.add("Préstamos");
        listDataHeader.add("Libros");
        listDataHeader.add("Lectores");

        // Agrega datos.
        List<String> prestamos = new ArrayList<String>();
        prestamos.add("Nuevo Préstamo");
        prestamos.add("En curso");
        prestamos.add("Devolución");
        prestamos.add("Historial");


        // Agrega datos.
        List<String> libros = new ArrayList<String>();
        libros.add("Nuevo libro");
        libros.add("Listado libros");
        libros.add("Nuevo autor");
        libros.add("Autores");
        libros.add("Categorías");
        libros.add("Idiomas");


        // Agrega datos.
        List<String> lectores = new ArrayList<String>();
        lectores.add("Nuevo lector");
        lectores.add("Listado lectores");
        lectores.add("Departamento");
        lectores.add("Curso");


        listDataChild.put(listDataHeader.get(0), prestamos);
        listDataChild.put(listDataHeader.get(1), libros);
        listDataChild.put(listDataHeader.get(2), lectores);
    }

    //Cards

    //Lista para cambiar de fragment
    private Fragment expandableListFragment(String s){
        if(s.equalsIgnoreCase("listado libros")){
            return new listar_libro();
        }else if(s.equalsIgnoreCase("nuevo libro")){
            return new crear_libro();
        }else if(s.equalsIgnoreCase("Encargado")){
            return new nuevo_encargado();
        }else if(s.equalsIgnoreCase("inicio")){
                return new inicio();

        }
        return new inicio();
    }
    //On destroy para destruir los fragmentos al cambiar de fragmento

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
    }
    private void crearFragmento(String s) {
        Fragment fragment = expandableListFragment(s);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_principal, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}