package com.example.tab_layout_viewpager2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //data coming from repo
        val images= listOf<Int>(
            R.drawable.ferrari_f1_imola_2022,
            R.drawable.car5,
            R.drawable.image44,
            R.drawable.image33,
            R.drawable.wallpapers,
            R.drawable.image22,
        )
        //setting the adapter for ViewPager2
        val adapter=ViewPagerAdapter(images)
        viewpager2.adapter=adapter

        //tabLayout.setupWithViewPager() cannot be used for viewpager2

        TabLayoutMediator(tabLayout,viewpager2){tab,position ->
             tab.text="Tab-$position"
        }.attach()

        tabLayout.addOnTabSelectedListener(object:OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //set the badge
                val badgeDrawable =tab?.orCreateBadge
                badgeDrawable?.isVisible = true
                badgeDrawable?.number = 3
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.removeBadge()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Re-Selected", Toast.LENGTH_SHORT).show()
            }
        })

    }
}