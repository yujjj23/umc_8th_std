package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.CustomerAdapter
import com.example.Profile
import com.example.ProfileDatabase
import com.example.test.databinding.ActivityMainBinding

import java.util.ArrayList

class MainActivity : ComponentActivity() {
    var list=ArrayList<Profile>()
    lateinit var customerAdapter: CustomerAdapter
    lateinit var db: ProfileDatabase

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=ProfileDatabase.getInstance(this)!!

        Thread{
            val savedContacts= db.profileDao().getAll()
            if(savedContacts.isNotEmpty()){
                list.addAll(savedContacts)
            }
        }.start()

        binding.button.setOnClickListener{
            Thread{
                list.add(Profile("베어","24","0000"))
                db.profileDao().insert(Profile("베어","24","0000"))

                val list=db.profileDao().getAll()
                Log.d("inserted Primary key", list[list.size-1].id.toString())
            }.start()
            customerAdapter.notifyDataSetChanged()
        }

        customerAdapter= CustomerAdapter(list, this)

        binding.mainProfileLv.adapter=customerAdapter
    }

}

