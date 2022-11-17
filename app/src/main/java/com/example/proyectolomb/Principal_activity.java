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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectolomb.databinding.ActivityPrincipalBinding;
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
    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;

    private static final int DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Copiar despues
        linearLayoutDetails = findViewById(R.id.linearLayoutDetails);
        imageViewExpand = findViewById(R.id.imageViewExpand);

      setSupportActionBar(binding.appBarPrincipal.toolbar);
        binding.appBarPrincipal.btsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        DrawerLayout drawer = binding.drawerLayout;
        ExpandableListView expListView = binding.expandableList;
        prepareListData();
        listAdapterExpandable = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapterExpandable);
        int count = listAdapterExpandable.getGroupCount();
        for ( int i = 0; i < count; i++ )
            expListView.collapseGroup(i);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
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
    //Copiar despues
    public void toggleDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }
}