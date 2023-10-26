package com.asiae.listview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //문자열 데이터로 된 리스트
        val list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("a","b"))
        list_item.add(ListViewModel("c","d"))
        list_item.add(ListViewModel("e","f"))

        // acivity_main.xml에 있는 ListView의 id 이름이 mainListview
        val listview = findViewById<ListView>(R.id.mainListview)

        // ListViewAdapter에 list_item("A","B","C") 넣기
        val listAdapter = ListViewAdapter(list_item)
        // listview의 adapter에 위에서 val로 선언한 listAdapter를 연결
        listview.adapter = listAdapter
    }
}