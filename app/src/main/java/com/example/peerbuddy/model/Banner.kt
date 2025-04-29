package com.example.peerbuddy.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Banner(
    val imageResources: Int,
    val title: String
): Parcelable
