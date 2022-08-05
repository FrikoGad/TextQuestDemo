package com.example.textquest

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Bad Code

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tv_main)

        val step1 = getString(R.string.step_1)
        val action1 = getString(R.string.step_1_action_1)
        val action2 = getString(R.string.step_1_action_2)

        val spannableString = SpannableString(step1)

        val action1ClickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                TODO("Not yet implemented")
            }
        }
        val action2ClickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                TODO("Not yet implemented")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = Color.parseColor("#FF0000")
            }
        }

        spannableString.setSpan(
            action1ClickSpan,
            step1.indexOf(action1),
            step1.indexOf(action1) + action1.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            action1ClickSpan,
            step1.indexOf(action2),
            step1.indexOf(action2) + action2.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.run {
            text = spannableString
            movementMethod = LinkMovementMethod.getInstance()
            highlightColor = Color.TRANSPARENT
        }
    }
}