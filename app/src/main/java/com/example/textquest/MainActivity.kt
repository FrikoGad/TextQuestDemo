package com.example.textquest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), ActionCallback {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tv_main)

        viewModel = MainViewModel(
            Repository.Base(this, ReadRawResource.Base(applicationContext), Gson())
        )
        viewModel.liveData.observe(this) {
            it.show(textView)
        }

        viewModel.nextScreen("1")
    }

    override fun moveToScreen(id: String) {
        viewModel.nextScreen(id)
    }
}