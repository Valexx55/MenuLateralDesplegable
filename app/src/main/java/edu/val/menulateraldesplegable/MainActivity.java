package edu.val.menulateraldesplegable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean menu_visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //con esta instrucción personalizo el icono del menú
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        this.drawerLayout = findViewById(R.id.drawer); //envoltorio menú "anima"
        this.navigationView = findViewById(R.id.navview); //el propio menú lateral

        this.navigationView.setNavigationItemSelectedListener(this);

    }

    //este método, recibe el callback, cuando tocas la hamburguesa
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //toca la hamburguesa
        switch (item.getItemId())
        {
            case android.R.id.home :
                Log.d("ETIQUETA_LOG", "Hamburguesa tocada");
                if (menu_visible)
                {
                    //ocultarlo
                    drawerLayout.closeDrawers();
                    menu_visible =false;
                } else
                {
                    //mostrarlo
                    drawerLayout.openDrawer(GravityCompat.START);//se abre de derecha izquieras
                    menu_visible =true;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //este método, recibe el callback, cuando tocabas una opción de menú desplegable
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getOrder())
        {
            case 0:
                Toast.makeText(this, "HOLA SOCIO", Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawers();
                menu_visible = false;
                break;
            case 1:
                this.finish();
                break;
        }
        return false;
    }
}