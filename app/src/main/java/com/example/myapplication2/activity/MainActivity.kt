package com.example.myapplication2.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        btn_sticky_list.setOnClickListener {
            val intent = Intent(this@MainActivity, StickyActivity::class.java)
            startActivity(intent)
        }
        btn_expandable.setOnClickListener {
            val intent = Intent(this@MainActivity, ExpandableActivity::class.java)
            startActivity(intent)
        }
    }
}