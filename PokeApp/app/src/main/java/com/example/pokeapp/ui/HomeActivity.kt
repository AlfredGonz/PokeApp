package com.example.pokeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeapp.HomeViewModel
import com.example.pokeapp.databinding.ActivityHomeBinding


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

        val bundle = intent.extras
        val username = bundle?.getString("username")
        val provider = bundle?.getString("provider")
        setup(username ?: "", provider ?: "")

        binding.regionesRecycler.layoutManager = LinearLayoutManager(this)
        val viewModel: HomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val adapter = RegionesAdapter()
        binding.regionesRecycler.adapter = adapter

        viewModel.rlist.observe(this, Observer {
            rlist-> adapter.submitList(rlist)
            emptyView(rlist)
        })

        adapter.onItemClickListener = {
            Toast.makeText(this, it.regionname, Toast.LENGTH_LONG).show()
        }

    }

    private fun emptyView(rlist: MutableList<Regiones>) {
        if (rlist.isEmpty()) {
            binding.emptyView.visibility = View.VISIBLE
        } else {
            binding.emptyView.visibility = View.GONE
        }
    }

    private fun setup(username: String?, provider: String){
        title = "Inicio"
        binding.txtUsername.text = "Hola, $username"
//        binding.btnLogout.setOnClickListener {

//            if (provider == ProviderType.FACEBOOK.name){
//                LoginManager.getInstance().logOut()
//            } else if (provider == ProviderType.GOOGLE.name) {
//                signOutFromApp()
//            }


        }
    }

//    private fun signOutFromApp() {
//        GoogleSignIn.getClient(
//            this,
//            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
//        ).signOut()
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
