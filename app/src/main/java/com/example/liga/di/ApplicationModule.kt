package com.example.liga.di

import android.content.Context
import androidx.room.Room
import com.example.liga.data.local.LigaDao
import com.example.liga.data.local.dao.CompetitionDao
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.utils.Constants.Companion.BASE_URL
import com.example.liga.domain.utils.Constants.Companion.TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    fun baseUrl() = BASE_URL

    @Provides
    fun logging() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder().addInterceptor {
        val request = it.request().newBuilder().addHeader("X-Auth-Token", TOKEN).build()
        it.proceed(request)
    }.addInterceptor(logging()).build()

    @Provides
    fun gson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(): SimpleRetro =
        Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(gson())
            .client(okHttpClient())
            .build()
            .create(SimpleRetro::class.java)
    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            LigaDao::class.java,
            "liga_database"
        ).build()

    @Provides
    fun provideCompetition(appDataBase : LigaDao) : CompetitionDao{
        return appDataBase.ligaCompetitionDao()
    }
}