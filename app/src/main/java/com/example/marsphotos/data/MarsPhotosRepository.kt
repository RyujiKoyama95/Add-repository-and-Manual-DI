package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApi
import com.example.marsphotos.network.MarsApiService
import retrofit2.Retrofit

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

// コンストラクタの引数名はこのクラスが知っている名前をつける。
// MarsPhotosRepositoryImplを参照するのはDefaultAppContainerで,
// retrofitServiceをコンストラクタに渡しているからといって、MarsPhotosRepositoryImplのコンストラクタの引数名を
// retrofitServiceにはしない。なぜなら、MarsPhotosRepositoryImplはretrofitServiceなんて知らないから。
class MarsPhotosRepositoryImpl(private val marsApiService: MarsApiService): MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}