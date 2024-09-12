package com.rodrigotguerra.livrando.core.ui.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visible", "invisibleType", requireAll = false)
fun View.visible(visible: Boolean, invisibleType: Int? = null) {
    visibility = if (visible) View.VISIBLE else invisibleType ?: View.GONE
}