package com.kiryanov.royality

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView

@BindingAdapter("android:res_src")
fun setImageResource(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}

@BindingAdapter(value = ["android:text_res", "android:text_append"])
fun setTextResource(textView: TextView, resId: Int, append: String) {
    textView.setText(resId)
    textView.append(" $append")
}