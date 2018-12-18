package com.infy.dagger2kotlin.di.module


import com.infy.dagger2kotlin.networking.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
class RetrofitModule {

     val httpLoggingInterceptor: HttpLoggingInterceptor
        @Provides
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

    @Provides
     fun getApiInterface(retroFit: Retrofit): ApiInterface {
        return retroFit.create<ApiInterface>(ApiInterface::class.java!!)
    }

    @Provides
     fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
     fun getOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    companion object {
        //example url replace your base url here
        private val BASE_URL = "https://xyz.com/api/"
    }

}
