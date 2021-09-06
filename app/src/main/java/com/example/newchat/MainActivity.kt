package com.example.newchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.ktx.FirebaseDatabaseKtxRegistrar
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.FirebaseCommonKtxRegistrar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MessagesCallBack {

    val fbManager = FBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       ibtSend.setOnClickListener {
           fbManager.addMessage(etMessage.text.toString())
            etMessage.text.clear()}
        fbManager.getAllMessages()

    }

    override fun onAllMessages(messages: ArrayList<String>) {

        rvMessages.adapter = ChatAdapter(this,messages)
        rvMessages.layoutManager = LinearLayoutManager(this)
    }

}