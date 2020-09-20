package com.example.viewpager

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.task1.adapter.Task1Adapter
import com.example.viewpager.task1.data.Task1Data
import com.example.viewpager.utils.extensions.changeNavigationBarColor
import com.example.viewpager.utils.extensions.changeStatusBarColor
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import uz.xsoft.viewpager1.toDarkenColor

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Task1Adapter
    private var list = arrayListOf(
        Task1Data((R.drawable.stay_home), Color.parseColor("#F43757")),
        Task1Data((R.drawable.coronavirus1), Color.parseColor("#8A63B3")),
        Task1Data((R.drawable.ic_virus), Color.parseColor("#3C97E9"))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = Task1Adapter(list, this)
        pager.adapter = adapter
        pager.registerOnPageChangeCallback(pageChangeCallback)
        TabLayoutMediator(tabLayout1, pager) { _, _ ->
            next_page.setOnClickListener {
                pager.currentItem++
            }
            previous_page.setOnClickListener {
                pager.currentItem--
            }
        }.attach()
    }
    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            changeStatusBarColor(list[position].colorID.toDarkenColor())
            changeNavigationBarColor(list[position].colorID.toDarkenColor())
        }
    }
}