package com.mg.finaldiplomado.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.commit
import com.google.firebase.auth.FirebaseAuth
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.ActivityLoginBinding
import com.mg.finaldiplomado.view.fragments.EntryFragment


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()

    }

    private fun setup() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragmentLogin, EntryFragment())
        }
        val window = window
        val decorView: View = window.decorView
        val wic = WindowInsetsControllerCompat(window, decorView)
        wic.isAppearanceLightStatusBars = ColorUtils.calculateLuminance(getColor(R.color.black)) > 0.5
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
    public override fun onResume() {
        super.onResume()
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val pass = Intent(this, MenuActivity::class.java)
            startActivity(pass)
            finish()
        } else {
            setup()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
