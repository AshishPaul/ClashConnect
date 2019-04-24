package com.example.unidirectionalstateflow.ui.modules.home

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.ui.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController
        home_bottom_navigation.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_dashboard_fragment, R.id.navigation_clan_list_fragment, R.id.navigation_settings_fragment))

        toolbar
            .setupWithNavController(navController, appBarConfiguration)
    }

}
