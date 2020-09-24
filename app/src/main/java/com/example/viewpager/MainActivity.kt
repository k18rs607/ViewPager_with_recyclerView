package com.example.viewpager

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.task1.adapter.MyAdapter
import com.example.viewpager.task1.adapter.Task1Adapter
import com.example.viewpager.task1.data.Model
import com.example.viewpager.task1.data.Task1Data
import com.example.viewpager.utils.extensions.changeNavigationBarColor
import com.example.viewpager.utils.extensions.changeStatusBarColor
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import uz.xsoft.viewpager1.toDarkenColor

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Task1Adapter//頻繁に変更されるデータに基づく要素のスクロール リストをアプリで表示する必要がある場合、 RecyclerView を使用する必要があります。
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

//import android.net.Uri
//import android.os.Bundle
//import android.view.View
//import android.widget.*
//import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.fragment0.*
//
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        /*list*/
//        var listview = findViewById<ListView>(R.id.listView)
////        var listview1 = findViewById<ListView>(R.id.listView1)
////        var listview2 = findViewById<ListView>(R.id.listView2)
//
//
//
//        var list = mutableListOf<Model>()//mutableListOfは変更可能のlistで、Modelの形の物をlistに追加していく。
//        list.add(Model("九州の外来<1F•2F>", "黒潮が流れる九州南部の温暖な海を再現した、水深７メートルの外洋大水槽。上層、中層、低層と、それぞれに自然界で生き残るための生活スタイルが見てとれます。", R.drawable.image2))
//        list.add(Model("かいじゅうアイランド<1F>", "いろいろな角度から観察したり、身近に触れあったりできる屋外エリア。", R.drawable.image3))
//        list.add(Model("九州の深海<1F>", "低水温•高水温•低酸素という過酷な環境で進化をとげと生きものたち。", R.drawable.image3))
//        list.add(Model("福岡の身近なイルカ<1F>", "日常を忘れて、スローな時間と癒しのリズムをお楽しみください。", R.drawable.image3))
//        list.add(Model("情報ひろば うみのたね<1F>", "館内展示や自然環境のことを知る、考えるきっかけとなる学びの場。", R.drawable.image3))
//
//        listview.adapter = MyAdapter(this, R.layout.row, list)// adapterにより これないと消える           AraayAdaoterで継承 MyAdapter
//
////上はフラグメント１に追加 listvuewのidを指定。
//
///*videoList*/