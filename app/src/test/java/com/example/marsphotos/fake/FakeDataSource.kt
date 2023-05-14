package com.example.marsphotos.fake

import com.example.marsphotos.model.MarsPhoto

// シングルトンでいいので、object宣言
object FakeDataSource {
    const val dummyId1 = "dummyId1"
    const val dummyId2 = "dummyId2"
    const val imgSrc1 = "imgSrc1"
    const val imgSrc2 = "imgSrc2"

    val dummyList = listOf(
        MarsPhoto(
            dummyId1,
            imgSrc1
        ),
        MarsPhoto(
            dummyId2,
            imgSrc2
        )
    )
}