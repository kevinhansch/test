package app.itdivision.lightbulb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.itdivision.lightbulb.Adapter.HomepageRecyclerViewAdapter;
import app.itdivision.lightbulb.Model.Course;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    List<Course> courseList;
    RecyclerView homepageRecycler;
    Spinner hmSelectCategory;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        if(text.equals("Select Category..")){
            courseList = new ArrayList<>();
            courseList.add(new Course("Build Android with Java", "Information Technology", (float) 100));
            courseList.add(new Course("Menggambar Objek Benda", "Art & Design", (float) 100));
            courseList.add(new Course("Business Model Canvas", "Business", (float) 100));
            courseList.add(new Course("Help Others with ChatBot", "Information Technology", (float) 100));
            courseList.add(new Course("Teknik Gambar Perspektif", "Art & Design", (float) 100));
            courseList.add(new Course("Data Structures in C", "Information Technology", (float) 100));

        }else if(text.equals("Information Technology")){
            courseList = new ArrayList<>();
            courseList.add(new Course("Build Android with Java", "Information Technology", (float) 100));
            courseList.add(new Course("Help Others with ChatBot", "Information Technology", (float) 100));
            courseList.add(new Course("Data Structures in C", "Information Technology", (float) 100));


        }else if(text.equals("Art and Design")){
            courseList = new ArrayList<>();
            courseList.add(new Course("Menggambar Objek Benda", "Art & Design", (float) 100));
            courseList.add(new Course("Teknik Gambar Perspektif", "Art & Design", (float) 100));

        }else if(text.equals("Physics")){
            courseList = new ArrayList<>();

        }else if(text.equals("Music")){
            courseList = new ArrayList<>();
        }else if(text.equals("English")){
            courseList = new ArrayList<>();
        }else if(text.equals("Business")){
            courseList = new ArrayList<>();
            courseList.add(new Course("Business Model Canvas", "Business", (float) 100));
        }else{
            courseList = new ArrayList<>();
        }

        homepageRecycler = (RecyclerView) findViewById(R.id.recyclerHomepage);
        HomepageRecyclerViewAdapter homepageAdapter = new HomepageRecyclerViewAdapter(this, courseList);
        homepageRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        homepageRecycler.setAdapter(homepageAdapter);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navdrawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //GridView + Recycler
//        courseList = new ArrayList<>();
//        courseList.add(new Course("Build Android with Java", "Information Technology", (float) 100));
//        courseList.add(new Course("Menggambar Objek Benda", "Art & Design", (float) 100));
//        courseList.add(new Course("Business Model Canvas", "Business", (float) 100));
//        courseList.add(new Course("Help Others with ChatBot", "Information Technology", (float) 100));
//        courseList.add(new Course("Teknik Gambar Perspektif", "Art & Design", (float) 100));
//        courseList.add(new Course("Data Structures in C", "Information Technology", (float) 100));
//
//        homepageRecycler = (RecyclerView) findViewById(R.id.recyclerHomepage);
//        HomepageRecyclerViewAdapter homepageAdapter = new HomepageRecyclerViewAdapter(this, courseList);
//        homepageRecycler.setLayoutManager(new GridLayoutManager(this, 2));
//        homepageRecycler.setAdapter(homepageAdapter);

        //Category Selection
        hmSelectCategory = (Spinner) findViewById(R.id.select_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.homepage_selection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hmSelectCategory.setAdapter(adapter);
        hmSelectCategory.setOnItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.homepage_drw) {
            //
        } else if (id == R.id.mycourse_drw) {
            Intent myCourseIntent = new Intent(Homepage.this, MyCourses.class);
            startActivity(myCourseIntent);
        } else if (id == R.id.profile_drw) {
            Intent profileIntent = new Intent(Homepage.this, Profile.class);
            startActivity(profileIntent);
        } else if (id == R.id.accsett_drw) {
            Intent accsettIntent = new Intent(Homepage.this, AccountSetting.class);
            startActivity(accsettIntent);
        } else if (id == R.id.notif_drw) {
            //
        } else if (id == R.id.aboutus_drw) {
            //
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
