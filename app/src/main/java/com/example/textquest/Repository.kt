package com.example.textquest

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson

interface Repository {

    fun nextScreen(id: String) : ScreenUI
    class Base(
        private val actionCallback: ActionCallback,
        readRawResource: ReadRawResource,
        gson: Gson
    ) : Repository {

        private val screensData: ScreensData =
            gson.fromJson(readRawResource.read(R.raw.quest), ScreensData::class.java)
        override fun nextScreen(id: String) : ScreenUI {
            screensData.screensList.find {
                it.id == id
            }!!. let { screensData ->
                val actions = screensData.actionsList.map { actionData ->
                    ActionUI(actionCallback, actionData.screenId, actionData.key)
                }
                return ScreenUI(screensData.text, actions)
            }
        }
    }
}

interface ReadRawResource {
    fun read(@RawRes id: Int) : String

    class Base(private val context: Context) : ReadRawResource {
        override fun read(id: Int) : String =
            context.resources.openRawResource(id).bufferedReader().readText()
    }
}