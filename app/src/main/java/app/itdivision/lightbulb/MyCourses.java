package app.itdivision.lightbulb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.itdivision.lightbulb.Adapter.MyCoursesRecyclerViewAdapter;
import app.itdivision.lightbulb.Model.MyCourse;

public class MyCourses extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    List<MyCourse> myCourseList;
    RecyclerView myCourseRecycler;
    Spinner statusSpinner;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        if(text.equals("Select Completion Status..")){
            myCourseList = new ArrayList<>();
            myCourseList.add(new MyCourse("Kotlin on Android", "Information Technology", (float) 100, false));
            myCourseList.add(new MyCourse("Teknik Menggambar Batik", "Art & Design", (float) 100, false));
            myCourseList.add(new MyCourse("Marketing Strategies", "Business", (float) 100, false));
            myCourseList.add(new MyCourse("E-Business", "Business", (float) 100, true));
            myCourseList.add(new MyCourse("Teknik Gambar Perspektif", "Art & Design", (float) 100, true));
            myCourseList.add(new MyCourse("Data Structures in C", "Information Technology", (float) 100, true));
        }else if(text.equals("ON GOING")){
            myCourseList = new ArrayList<>();
            myCourseList.add(new MyCourse("Kotlin on Android", "Information Technology", (float) 100, false));
            myCourseList.add(new MyCourse("Teknik Menggambar Batik", "Art & Design", (float) 100, false));
            myCourseList.add(new MyCourse("Marketing Strategies", "Business", (float) 100, false));
        }else if(text.equals("COMPLETED")){
            myCourseList = new ArrayList<>();
            myCourseList.add(new MyCourse("E-Business", "Business", (float) 100, true));
            myCourseList.add(new MyCourse("Teknik Gambar Perspektif", "Art & Design", (float) 100, true));
            myCourseList.add(new MyCourse("Data Structures in C", "Information Technology", (float) 100, true));
        }

        myCourseRecycler = (RecyclerView) findViewById(R.id.recyclerMyCourses);
        MyCoursesRecyclerViewAdapter myCoursesAdapter = new MyCoursesRecyclerViewAdapter(this, myCourseList);
        myCourseRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        myCourseRecycler.setAdapter(myCoursesAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);
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

        //Completed Status Selection
        statusSpinner = (Spinner) findViewById(R.id.select_status);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mycourses_selection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter);
        statusSpinner.setOnItemSelectedListener(this);
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
            Intent homepageIntent = new Intent(this, Homepage.class);
            startActivity(homepageIntent);
        } else if (id == R.id.mycourse_drw) {

        } else if (id == R.id.profile_drw) {
            Intent profileIntent = new Intent(this, Profile.class);
            startActivity(profileIntent);
        } else if (id == R.id.accsett_drw) {
            Intent accsettIntent = new Intent(this, AccountSetting.class);
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
