package com.example.ekspresiku

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    var title: String,
    var description: String,
    var photo: Int
) : Parcelable
