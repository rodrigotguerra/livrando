package com.rodrigotguerra.livrando.core.data.utils

import androidx.lifecycle.LiveData

fun <T> T.toLiveData() = this as LiveData<T>