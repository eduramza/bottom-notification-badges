package com.eduramza.googlenotificationbadge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBadge()
        BottomMenuHelper.showBadge(this, bottom_nav_view, R.id.action_photo, "5")

    }

    private fun addBadge(){
        val badge : BadgeDrawable = bottom_nav_view.getOrCreateBadge(
            R.id.action_home
        )
        badge.number = 3
        badge.isVisible = true
    }

    private fun removeBadge(){
        bottom_nav_view.removeBadge(R.id.tv_bottom_nav_badge)
    }

}