package com.example.covidtracker2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Console
import java.lang.reflect.GenericArrayType

private val Response.StateWise: Any
    get() {}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchResult()
    }

    private fun fetchResult(){
        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) { Client.api.execute() }
            if(response.isSuccessful)
            {
                val data = Gson().fromJson(response.body?.string(),response::class.java)
                launch (Dispatchers.Main){
                    bindCombinedData(data.stateWise?.get(0))
                }
            }
        }
    }

    private fun bindCombinedData(get: StateWiseItem){

    }
}