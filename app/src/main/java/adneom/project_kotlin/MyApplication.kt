package adneom.project_kotlin

import adneom.project_kotlin.network.LoggingInterceptor
import adneom.project_kotlin.network.TestService
import adneom.project_kotlin.utils.Utils
import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gtshilombowanticale on 01-09-17.
 */

class MyApplication : Application() {

    private lateinit var service : TestService

    override fun onCreate() {
        super.onCreate()

        var retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .client(initializeOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        service = retrofit.create(TestService::class.java)
    }

    fun getService() : TestService {
        return service
    }

    fun initializeOkHttp() : OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .build()
    }

}