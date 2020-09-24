package com.example.viewpager.task1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import com.example.viewpager.R
import com.example.viewpager.task1.data.Model
import com.example.viewpager.R.id.textView1
import com.example.viewpager.R.id.textView2


//class Model(val title: String, val description: String, val img:Int) {//class (val title:String,val description:String,val image:Bitmap)

class MyAdapter(var mCtx: Context, var resources: Int, var items: List<Model>):ArrayAdapter<Model>( //宣言 <int>(context(mCtx:): Context, resource: Int, textViewResourceId(items:): Int(List<Model>))
    mCtx,//context 環境
    resources,//string、drawable、layout のようなタイプにグループ化
    items//textViewResourceId
)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //データオブジェクトに使用するビューのタイプをカスタマイズするには、getView（int、android.view.View、android.view.ViewGroup）をオーバーライドして、ビューリソースを拡張します。デフォルトは、テキスト表示

        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)//環境 layoutについて

        val view:View=layoutInflater.inflate(resources, null)//layout viewについて

        val imageView:ImageView=view.findViewById(R.id.image)//drawable imageview


        val titleTextView:TextView = view.findViewById(textView1)//textViewResourceId textview1
        val descriptionTextView:TextView=view.findViewById(textView2)//textViewResourceId、今回のdescriptionは解説的な意味 textview2


        var mItem:Model = items[position]//listを示すrowの位置を指すmItem。

        titleTextView.text=mItem.title//mItem.titleはrowにあたるitemの中のtitleにあたる。
        descriptionTextView.text=mItem.description//mItem.descriptionはrowにあたるitemの中のsubtitleにあたる。
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))//mItem.imgはModelの中のdescriptionであり、MyAdapterのmCtx、resourcesにあたる。itemはrowにあたるから違う。
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))

        return view
    }
}