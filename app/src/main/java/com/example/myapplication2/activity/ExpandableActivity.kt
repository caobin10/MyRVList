package com.example.myapplication2.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter.OnHeaderClickListener
import com.example.myapplication2.R
import com.example.myapplication2.adapter.ExpandableAdapter
import com.example.myapplication2.model.GroupModel
import kotlinx.android.synthetic.main.activity_group_list.*

class ExpandableActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_list)
        rv_list.layoutManager = LinearLayoutManager(this)
        val adapter = ExpandableAdapter(this, GroupModel.getExpandableGroups(10, 5))
        adapter.setOnHeaderClickListener(OnHeaderClickListener { adapter, holder, groupPosition -> //                Toast.makeText(ExpandableActivity.this, "组头：groupPosition = " + groupPosition,
//                        Toast.LENGTH_LONG).show();
            val expandableAdapter: ExpandableAdapter = adapter as ExpandableAdapter
            if (expandableAdapter.isExpand(groupPosition)) {
                expandableAdapter.collapseGroup(groupPosition)
            } else {
                expandableAdapter.expandGroup(groupPosition)
            }
        })
        adapter.setOnChildClickListener(GroupedRecyclerViewAdapter.OnChildClickListener { adapter, holder, groupPosition, childPosition ->
            Toast.makeText(
                this@ExpandableActivity, "子项：groupPosition = " + groupPosition
                        + ", childPosition = " + childPosition,
                Toast.LENGTH_LONG
            ).show()
        })
        rv_list.adapter = adapter
    }
}