package com.asiae.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listviewItem)
        var content = convertView!!.findViewById<TextView>(R.id.listviewItem2)
        //title에 있는 text를 ListViewAdapter의 매개변수인 List 각각의 아이템들로 연결
        title.text = List[position].title
        content.text = List[position].content
        // List[0] -> ListViewModel("a","b")
        // List[1] -> ListViewModel("c","d")
        // List[2] -> ListViewModel("e","f")

        // !!는 널이 아님을 단언.
        // 만약 convertView가 널이라면, NullPointException 발생
        return convertView!!

    }
}