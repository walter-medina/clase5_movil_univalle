package com.example.clase5

import ViewPagerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.clase5.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupToolbar()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_contextual, menu)
        return true
    }

    private fun setupToolbar() {
        val toolbar = binding.contentToolbar.toolbar
        setSupportActionBar(toolbar)
        setupDrawer(toolbar)
        toolbar.title = "Activity Uno"
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu1 -> {
                //Tarea a realizar
                    true
                }

                R.id.menu2 -> {
                    //Tarea a realizar
                    true
                }

                else -> false
            }
        }

    }

    private fun setupDrawer(toolbar: Toolbar) {

        val drawerLayout = binding.drawerLayout
        val navView = binding.navView

        // para implementar un botón de navegación en el toolbar
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Configurar el listener para los elementos del Navigation Drawer
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    startActivity(Intent(this, MainActivity2::class.java))
                    drawerLayout.closeDrawer(navView)
                    true
                }

                R.id.nav_item2 -> {
                    Toast.makeText(this, "Opcion 2", Toast.LENGTH_LONG).show()
                    drawerLayout.closeDrawer(navView)
                    true
                }
                else -> false
            }
        }

    }


}