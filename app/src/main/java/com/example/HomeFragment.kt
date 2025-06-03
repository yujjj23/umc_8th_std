package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import me.relex.circleindicator.CircleIndicator3

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // 배너용 어댑터 (간단한 이미지 슬라이드 등)
    private lateinit var bannerAdapter: BannerAdapter

    // 탭용 어댑터 (전체, 즐겨찾기)
    private lateinit var tabAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 1) 배너 ViewPager2 + CircleIndicator 세팅
        bannerAdapter = BannerAdapter(this)
        binding.bannerViewPager.adapter = bannerAdapter

        val indicator = binding.bannerIndicator as CircleIndicator3
        indicator.setViewPager(binding.bannerViewPager)

        // 2) 탭 ViewPager2 + TabLayout 세팅
        tabAdapter = ViewPagerAdapter(this)
        binding.tabViewPager.adapter = tabAdapter
        binding.tabViewPager.offscreenPageLimit = 2

        TabLayoutMediator(binding.tabLayout, binding.tabViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "전체"
                1 -> "즐겨찾기"
                else -> "탭${position + 1}"
            }
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


