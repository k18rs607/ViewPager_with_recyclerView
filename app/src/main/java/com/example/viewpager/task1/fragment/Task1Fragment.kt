package com.example.viewpager.task1.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.viewpager.R
import kotlinx.android.synthetic.main.task1_page.*

class Task1Fragment : Fragment(R.layout.task1_page) {
    private var listener: ((Int) -> Unit)? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = requireArguments()
        val image = bundle.getInt("IMAGE_ID")
        val color = bundle.getInt("COLOR_ID")
        image1.setBackgroundResource(image)
        task1_content1.setBackgroundColor(color)
    }
}