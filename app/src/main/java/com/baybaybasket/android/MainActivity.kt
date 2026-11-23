package com.baybaybasket.android

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 64, 48, 48)
        }
        content.addView(TextView(this).apply {
            text = "Baybay Basket"
            textSize = 28f
        })
        content.addView(TextView(this).apply {
            text = "Browse verified local groceries and create a one-business basket."
            textSize = 16f
        })
        setContentView(content)
    }
}
