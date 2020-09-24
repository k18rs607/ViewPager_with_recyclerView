package com.example.viewpager.task1.fragment

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.viewpager.R
import com.example.viewpager.task1.adapter.MyAdapter
import com.example.viewpager.task1.data.Model
import kotlinx.android.synthetic.main.task1_page.*

class Task1Fragment : Fragment(R.layout.task1_page) {
    private var listener: ((Int) -> Unit)? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//                        setContentViewView(R.layout.task1_page)
        val bundle = requireArguments()
        val image = bundle.getInt("IMAGE_ID")
        val color = bundle.getInt("COLOR_ID")
        image1.setBackgroundResource(image)
        task1_content1.setBackgroundColor(color)


        
//                /*list*/
//        var listview = findViewById<ListView>(R.id.listView)
//        var list1 = mutableListOf<Model>()//mutableListOfは変更可能のlistで、Modelの形の物をlistに追加していく。
//        list1.add(Model("九州の外来<1F•2F>", "黒潮が流れる九州南部の温暖な海を再現した、水深７メートルの外洋大水槽。上層、中層、低層と、それぞれに自然界で生き残るための生活スタイルが見てとれます。", R.drawable.coronavirus1))
//        list1.add(Model("かいじゅうアイランド<1F>", "いろいろな角度から観察したり、身近に触れあったりできる屋外エリア。", R.drawable.coronavirus1))
//        list1.add(Model("九州の深海<1F>", "低水温•高水温•低酸素という過酷な環境で進化をとげと生きものたち。", R.drawable.coronavirus1))
//        list1.add(Model("福岡の身近なイルカ<1F>", "日常を忘れて、スローな時間と癒しのリズムをお楽しみください。", R.drawable.coronavirus1))
//        list1.add(Model("情報ひろば うみのたね<1F>", "館内展示や自然環境のことを知る、考えるきっかけとなる学びの場。", R.drawable.coronavirus1))
//
//        listview.adapter = MyAdapter(this, R.layout.row, list1)// adapterにより これないと消える           AraayAdaoterで継承 MyAdapter
//
////上はフラグメント１に追加 listvuewのidを指定。
    }
}


