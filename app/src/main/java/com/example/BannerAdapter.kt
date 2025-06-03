package com.example

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val bannerItems = listOf(
        BannerFragment.newInstance("배너1 이미지 url or 리소스"),
        BannerFragment.newInstance("배너2 이미지 url or 리소스"),
        BannerFragment.newInstance("배너3 이미지 url or 리소스")
    )

    override fun getItemCount(): Int = bannerItems.size

    override fun createFragment(position: Int): Fragment = bannerItems[position]
}
