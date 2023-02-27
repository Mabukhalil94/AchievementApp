package com.example.achievement.data.model

data class AchievementResponseModel(
    val id: Int,
    val label: String,
    val records: List<RecordResponseModel>,
    val title: String
)