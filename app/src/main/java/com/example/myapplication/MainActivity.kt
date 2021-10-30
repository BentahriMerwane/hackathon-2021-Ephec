package com.example.myapplication


import android.annotation.SuppressLint

import android.content.Intent

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.login.LoginFragment
import com.example.myapplication.ui.repas.RepasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Un problème n'hésiter pas à contacter l'équipe Ephec Food", Snackbar.LENGTH_LONG)
            Snackbar.make(view, "Problème avec l'application , contacter le service : ephecfood@students.ephec.be", Snackbar.LENGTH_LONG)

                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_login, R.id.nav_commandes, R.id.nav_repas
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val button_sign = findViewById<Button>(R.id.button_sign)
        button_sign.setOnClickListener{

            // edit text login

            val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            val editTextPassword = findViewById<EditText>(R.id.text_input_password_toggle).text.toString()

            val textview_user = findViewById<TextView>(R.id.textView_users)
            textview_user.setText("EMAIL  : $editTextEmail")

            Toast.makeText(this ,"La connexion est accepté pour l'email" + editTextEmail, Toast.LENGTH_LONG).show();

        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}