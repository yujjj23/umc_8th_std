package com.example.week2_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.week2_1.databinding.ActivityMainBinding
import com.example.week2_1.ui.dashboard.DashboardFragment
import com.example.week2_1.ui.home.HomeFragment
import com.example.week2_1.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.navView

        // 기본적으로 홈 화면을 표시
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, HomeFragment())
                .commit()
        }

        // 네비게이션 뷰에서 아이템 선택 시
        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.navigation_home -> selectedFragment = HomeFragment()
                R.id.navigation_dashboard -> selectedFragment = DashboardFragment()
                R.id.navigation_notifications -> selectedFragment = NotificationsFragment()
            }

            // Fragment 전환 애니메이션 설정
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            // 슬라이드 애니메이션 (홈, 대시보드)
            if (item.itemId == R.id.navigation_home || item.itemId == R.id.navigation_dashboard) {
                transaction.setCustomAnimations(
                    R.anim.slide_in_from_right,  // 오른쪽에서 들어오는 애니메이션
                    R.anim.slide_out_to_left,    // 왼쪽으로 나가는 애니메이션
                    R.anim.slide_in_from_left,   // 왼쪽에서 들어오는 애니메이션
                    R.anim.slide_out_to_right    // 오른쪽으로 나가는 애니메이션
                )
            }
            // 페이드 인/아웃 효과 (노티피케이션)
            if (item.itemId == R.id.navigation_notifications) {
                transaction.setCustomAnimations(
                    android.R.anim.fade_in,  // 페이드 인 효과
                    android.R.anim.fade_out   // 페이드 아웃 효과
                )
            }

            // Fragment 전환
            transaction.replace(R.id.nav_host_fragment_activity_main, selectedFragment!!)
            transaction.commit()

            true
        }
    }
}


