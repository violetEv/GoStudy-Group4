package com.group4.gostudy.data.network.api.model.module

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DataModules(
    @SerializedName("modules")
    val module: List<ModuleItemResponse>?
)
