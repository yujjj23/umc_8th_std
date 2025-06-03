package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.test.MainActivity
import com.example.test.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btn_kakao).setOnClickListener {
            // 로그인 처리 로직
            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
            finish() // MainActivity로 돌아감
        }
    }
}
