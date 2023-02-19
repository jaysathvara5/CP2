package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.login.Fragments.FragmentChatbot
import com.example.login.Fragments.FragmentHome
import com.example.login.Fragments.FragmentProfile
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation =findViewById(R.id.bottomNavigation)

        val homeFragment=FragmentHome()
        val chatbotFragment=FragmentChatbot()
        val profileFragment=FragmentProfile()

        setCurrentFragment(homeFragment)

        bottomNavigation.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.navHome -> setCurrentFragment(homeFragment)
                    R.id.navbot ->setCurrentFragment(chatbotFragment)
                R.id.navProfile ->setCurrentFragment(profileFragment)
            }
            true
        }


    }

    private fun setCurrentFragment(Fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,Fragment)
            commit()
        }
    }
}


