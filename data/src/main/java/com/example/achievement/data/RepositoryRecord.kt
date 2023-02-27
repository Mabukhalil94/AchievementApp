package com.example.achievement.data

import com.example.achievement.data.api.RecordApi
import com.example.achievement.data.model.AchievementResponseModel
import com.example.achievement.data.retrofit.RetrofitBuilder


class RepositoryRecord {

    suspend fun getWrapperAchieve(): List<AchievementResponseModel> {
        val wrapperApi = RetrofitBuilder.getInstance().create(RecordApi::class.java)
        return wrapperApi.getWrapperAchievement().body()?.data!!
    }
}

