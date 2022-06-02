package com.test.testtasklighted

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.testtasklighted.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        setSupportActionBar(binding.mainAction)
        navView.setupWithNavController(navController)

        val drawerToggle = ActionBarDrawerToggle(
            this, binding.drawer, binding.mainAction,
            R.string.nav_drawer_opened,
            R.string.nav_drawer_closed
        )
        drawerToggle.isDrawerIndicatorEnabled = false
        drawerToggle.syncState()
        val drawable = ResourcesCompat.getDrawable(
            resources,
            R.drawable.ic_drawer,
            theme
        )

        drawerToggle.setHomeAsUpIndicator(drawable)
        binding.drawer.setDrawerListener(drawerToggle)
    }
}