package com.example.newchat

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class FBManager (val callBack: MessagesCallBack): ExternalDB {

private val database = FirebaseDatabase.getInstance()
    override fun addMessage(message: String) {
        val reference = database.getReference("db").child("chat")
        val messageID = reference.push().key
        if (messageID != null) reference.child(messageID).setValue(message)

    }

    override fun getAllMessages(): ArrayList<String> {
        val messages = ArrayList<String>()
        val reference = database.getReference("db").child("chat")
        reference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                messages.clear()
                for (item in snapshot.children){
                    val value: String? = item.getValue(String::class.java)
                    if (value != null) messages.add(value)
                }
                callBack.onAllMessages(messages)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return messages
    }

}
interface MessagesCallBack{
    fun onAllMessages(messages :ArrayList<String>)
}