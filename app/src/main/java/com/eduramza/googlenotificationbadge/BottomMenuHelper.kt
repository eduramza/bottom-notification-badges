package com.eduramza.googlenotificationbadge

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomMenuHelper {

    companion object{
        fun showBadge(
            context: Context,
            bottomNavigationView: BottomNavigationView,
            @IdRes itemId: Int, value: String
        ){
            removeBadge(bottomNavigationView, itemId)
            val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
            val badge: View = LayoutInflater.from(context)
                .inflate(R.layout.custom_badge_layout, bottomNavigationView, false)

            val text: TextView = badge.findViewById(R.id.tv_bottom_nav_badge)
            text.text = value
            itemView.addView(badge)
        }

        private fun removeBadge(
            bottomNavigationView: BottomNavigationView,
            @IdRes itemId: Int) {
            val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
            if (itemView.childCount == 3) {
                itemView.removeViewAt(2)
            }
        }
    }
}