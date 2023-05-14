package com.example.marsphotos.fake

import android.util.Log
import com.example.marsphotos.data.MarsPhotosRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsPhotosRepositoryTest {
    companion object {
        const val TAG = "NetworkMarsPhotosRepositoryTest"
    }

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() {
        runTest {
            val repository = MarsPhotosRepositoryImpl(FakeMarsApiService())
            val result = repository.getMarsPhotos()
            assertEquals(FakeDataSource.dummyList, result)
        }
    }
}