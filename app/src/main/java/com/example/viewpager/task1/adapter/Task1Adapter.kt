package com.example.viewpager.task1.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.task1.data.Task1Data
import com.example.viewpager.task1.fragment.Task1Fragment
import com.example.viewpager.utils.extensions.putArguments

class Task1Adapter(private val data: List<Task1Data>, activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private var listener: ((Int) -> Unit)? = null
    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment = Task1Fragment().putArguments {

        putInt("IMAGE_ID",data[position].imgID)
        putInt("COLOR_ID",data[position].colorID)
    }
}

