package com.eduramza.googlenotificationbadge

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBadge()
        BottomMenuHelper.showBadge(this, bottom_nav_view, R.id.action_photo, "5")

        bottom_nav_view.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.action_home -> {
                    removeBagdeIfVisible(R.id.action_home)
                    true
                }
                R.id.action_photo -> {
                    removeBagdeIfVisible(R.id.action_photo)
                    true
                }
                R.id.action_perfil -> {
                    removeBagdeIfVisible(R.id.action_perfil)
                    true
                }
                else -> false
            }
        }

    }

    private fun addBadge(){
        val badge : BadgeDrawable = bottom_nav_view.getOrCreateBadge(
            R.id.action_home
        )
        badge.number = 3
        badge.isVisible = true
    }

    private fun removeBadge(menuItem: Int){
        bottom_nav_view.removeBadge(menuItem)
    }

    private fun removeBagdeIfVisible(menuItem: Int) {
        val badgeDrawable = bottom_nav_view.getBadge(menuItem)
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }
        BottomMenuHelper.removeBadge(bottom_nav_view, menuItem)
    }

}