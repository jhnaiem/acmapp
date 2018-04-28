package com.example.jahid.acm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jahid.acm.Adapter.MyAdapter;
import com.example.jahid.acm.model.itemof;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private RecyclerView drawerRecyclerView;
    private DrawerLayout myDrawer;
    private  ActionBarDrawerToggle myToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.myDrawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.mynv);
        navigationView.setNavigationItemSelectedListener(this);
        setFragment(new dataFragment());//init
        drawerRecyclerView = (RecyclerView) findViewById(R.id.drawerlist);
        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<itemof> itemofList = new ArrayList<>();

        itemofList.add( new itemof("Officials","Faculty Advisor","EB",true));
        itemofList.add(new itemof("Events","Upcoming Events","Previous Events",true));
        itemofList.add(new itemof("RECRUITMENT",false));
        itemof member = new itemof("MEMBER",true);
        member.setSubtext("GM");
        member.setSubtext2("Provetionary");
        itemofList.add(member);
        itemofList.add(new itemof("About NSUACMSC",false));

        MyAdapter adapter = new MyAdapter(itemofList);
        drawerRecyclerView.setAdapter(adapter);


        myDrawer= (DrawerLayout) findViewById(R.id.myDrawer);
        myToggle=new ActionBarDrawerToggle(this,myDrawer,R.string
        .open,R.string.close);

        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.myDrawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (myToggle.onOptionsItemSelected(item)){
            return true;
        }

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//
//        Fragment myfragment=null;
//        Class fragmentClass = null;
//        int id = item.getItemId();
//
//        if (id == R.id.i1) {
//
//        } else if (id == R.id.i2) {
//            setFragment(new Contacts());
//
//        } else if (id == R.id.i3) {
//
//        } else if (id == R.id.i4) {
//
//        }
//
//        return true;
//    }

    public void setFragment(Fragment fragment){
        if(fragment!=null){
            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.myDrawer);
        drawer.closeDrawer(GravityCompat.START);
    }



}
