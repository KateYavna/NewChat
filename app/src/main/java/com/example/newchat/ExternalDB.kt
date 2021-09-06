package com.example.newchat

interface ExternalDB {
    fun addMessage (message: String)
    fun getAllMessages (): ArrayList<String>
}