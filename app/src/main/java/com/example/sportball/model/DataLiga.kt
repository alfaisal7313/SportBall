package com.example.sportball.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataLiga(
    val id: Int? = 0,
    val name: String? = null,
    val dec: String? = null,
    val logo: Int? = 0
) : Parcelable