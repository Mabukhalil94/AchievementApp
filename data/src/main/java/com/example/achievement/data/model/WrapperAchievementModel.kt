package com.example.achievement.data.model

import com.google.gson.annotations.SerializedName

data class WrapperAchievementModel(

    @SerializedName("data")
    val data : List<AchievementResponseModel>
)