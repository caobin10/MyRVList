package com.example.myapplication2.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter.OnHeaderClickListener
import com.example.myapplication2.R
import com.example.myapplication2.adapter.NoFooterAdapter
import com.example.myapplication2.model.GroupModel
import kotlinx.android.synthetic.main.activity_sticky_list.*

class StickyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sticky_list)
        initView()
    }

    private fun initView() {
        //设置是否吸顶。是默认true，不吸顶设置false
//        sticky_layout.isSticky = false
        rv_list.layoutManager = LinearLayoutManager(this)
        val adapter = NoFooterAdapter(this, GroupModel.getGroups(10, 5))
        adapter.setOnHeaderClickListener(OnHeaderClickListener { adapter, holder, groupPosition ->
            Toast.makeText(
                this@StickyActivity, "组头：groupPosition = $groupPosition",
                Toast.LENGTH_LONG
            ).show()
            Log.e("eee", "$adapter  $holder")
        })

        adapter.setOnChildClickListener(GroupedRecyclerViewAdapter.OnChildClickListener { adapter, holder, groupPosition, childPosition ->
            Toast.makeText(
                this@StickyActivity, "子项：groupPosition = " + groupPosition
                        + ", childPosition = " + childPosition,
                Toast.LENGTH_LONG
            ).show()
        })
        rv_list.adapter = adapter
    }
}