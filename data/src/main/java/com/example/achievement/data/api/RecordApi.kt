package com.example.achievement.data.api

import com.example.achievement.data.model.WrapperAchievementModel
import retrofit2.Response
import retrofit2.http.GET

interface RecordApi {

    @GET("/achievements")
    suspend fun getWrapperAchievement() : Response<WrapperAchievementModel>
}