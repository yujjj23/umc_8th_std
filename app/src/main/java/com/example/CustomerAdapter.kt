package com.example

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import com.example.test.databinding.ItemLayoutBinding


class CustomerAdapter(val list: ArrayList<Profile>, context: Context) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)

        binding.text1.text = list[position].name
        binding.text2.text = list[position].age

        return binding.root
    }
}
