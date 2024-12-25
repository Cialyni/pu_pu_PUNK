package com.example.pupupunk.Model

import java.sql.Time

data class ItemActivity(
    val id: Int,
    val userName: String,
    val avatarPhoto: String,
    val activityDescription: String,
    val place: String,
    val date: String,
    val time: String
)