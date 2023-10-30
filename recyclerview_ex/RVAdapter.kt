package com.asiae.rv_ex_again

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// RecyclerView.Adapter<RVAdapter.Viewholder>는 RVAdapter.Viewholder를 사용하여 RecyclerView에 데이터를 표시하고 관리하는 데 사용되는 어댑터
class RVAdapter(val items : MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view: View, positon: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        if(itemClick != null) {
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : String) {
            // itemView는 rv_item.xml 내에 있는 TextView를 의미
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }

    }
}