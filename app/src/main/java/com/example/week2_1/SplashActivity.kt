package com.example.week2_1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 스플래시 화면의 레이아웃 설정
        setContentView(R.layout.activity_splash)

        // 일정 시간(3초) 후 MainActivity로 이동
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // SplashActivity를 종료
        }, 3000)  // 3초 후 MainActivity로 이동
    }
}
