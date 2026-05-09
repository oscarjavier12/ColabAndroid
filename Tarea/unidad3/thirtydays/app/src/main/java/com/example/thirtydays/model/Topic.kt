package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val titleRes: Int,
    val day: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)