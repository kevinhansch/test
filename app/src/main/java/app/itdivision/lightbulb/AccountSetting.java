package app.itdivision.lightbulb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AccountSetting extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CardView card_username;
    CardView card_email;
    CardView card_password;
    TextView tv_change_username;
    TextView tv_change_reward;
    TextView tv_change_member_since;
    TextView tv_change_email;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        //toolbars
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

        //main Content
        card_username = (CardView) findViewById(R.id.card_username);
        card_email = (CardView) findViewById(R.id.card_email);
        card_password = (CardView) findViewById(R.id.card_password);
        tv_change_username = (TextView) findViewById(R.id.tv_change_username);
        tv_change_reward = (TextView) findViewById(R.id.tv_change_reward);
        tv_change_member_since = (TextView) findViewById(R.id.tv_change_member_since);
        tv_change_email = (TextView) findViewById(R.id.tv_change_email);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        //OnclickListeners-Cards
        card_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountSetting.this, "Clicked Username Card", Toast.LENGTH_SHORT).show();
            }
        });
        card_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountSetting.this, "Clicked Email Card", Toast.LENGTH_SHORT).show();
            }
        });
        card_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountSetting.this, "Clicked Password Card", Toast.LENGTH_SHORT).show();
            }
        });

        //OnClickListeners-Button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AccountSetting.this, "Clicked Logout Button", Toast.LENGTH_SHORT).show();
            }
        });
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
            Intent mycourseIntent = new Intent(this, MyCourses.class);
            startActivity(mycourseIntent);
        } else if (id == R.id.profile_drw) {
            Intent profileIntent = new Intent(this, Profile.class);
            startActivity(profileIntent);
        } else if (id == R.id.accsett_drw) {
            //
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
