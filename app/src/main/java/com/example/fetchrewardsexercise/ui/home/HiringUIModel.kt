package com.example.fetchrewardsexercise.ui.home

import com.example.fetchrewardsexercise.models.HiringModel

data class HiringUIModel (
    val listId: Int,
    val name: String?,
)

fun dataToHiringUI(data: HiringModel): HiringUIModel {
    return HiringUIModel(
        listId = data.listId,
        name = data.name
    )
}