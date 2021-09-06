package com.example.newchat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message.view.*

class ChatAdapter(val context: Context, var messages : ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text = messages[position]
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val message = itemView.tvItemMessage
}