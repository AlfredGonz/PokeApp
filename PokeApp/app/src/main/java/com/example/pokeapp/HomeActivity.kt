package com.example.pokeapp

import android.app.LauncherActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeapp.databinding.ActivityHomeBinding
import com.example.pokeapp.databinding.ActivityMainBinding
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    GOOGLE,
    FACEBOOK
}

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle= intent.extras
        val username = bundle?.getString("username")
        val provider = bundle?.getString("provider")
        setup(username ?: "", provider ?: "")

        binding.btnLogout.setOnClickListener {  }
    }

    private fun setup(username: String?, provider: String){
        title = "Inicio"
        binding.txtUsername.text = "Hola, $username"
        binding.btnLogout.setOnClickListener {

            if (provider == ProviderType.FACEBOOK.name){
                LoginManager.getInstance().logOut()
            } else if (provider == ProviderType.GOOGLE.name) {
                signOutFromApp()
            }


        }
    }

    private fun signOutFromApp() {
        GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        ).signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}