package com.mg.finaldiplomado.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mg.finaldiplomado.R
import com.mg.finaldiplomado.databinding.ActivityMenuBinding
import com.mg.finaldiplomado.view.fragments.HomeFragment
import com.mg.finaldiplomado.view.fragments.ShopFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        setup()
    }

    private fun setup() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeNav -> replaceFragment(HomeFragment())
                R.id.shoppingNav -> replaceFragment(ShopFragment())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentMager = supportFragmentManager
        val fragmentTrasaction = fragmentMager.beginTransaction()
        fragmentTrasaction.replace(R.id.fragmentNav, fragment)
        fragmentTrasaction.commit()
    }
}