package id.kotlin.gnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //menyambungkan navigasi (fragment) dengan bottomnavbar
        val bottomnavbar = findViewById<BottomNavigationView>(R.id.bottomNavbar)
        val navController = findNavController(R.id.fragment_container)
        bottomnavbar.setupWithNavController(navController)
    }
}