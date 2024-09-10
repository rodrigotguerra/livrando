package com.rodrigotguerra.livrando.core.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rodrigotguerra.livrando.core.ui.R

fun ImageView.loadImage(url: String?) {
    val options =
        RequestOptions().placeholder(R.drawable.ic_book_open)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}

@BindingAdapter("android:image_url")
fun loadImageAdapter(view: ImageView, url: String?) {
    view.loadImage(url)
}