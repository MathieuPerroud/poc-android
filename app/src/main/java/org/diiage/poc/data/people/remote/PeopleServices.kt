package org.diiage.poc.data.people.remote

import org.diiage.poc.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.diiage.poc.data.sources.StarWarsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PeopleServices: PeopleRemote {



    private companion object {

        val API: StarWarsAPI by lazy {
            val gson = GsonBuilder()
                .create()

            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.API_STARWARS)
                .client(buildHttpClient())
                .build()
                .create(StarWarsAPI::class.java)
        }

        private fun buildHttpClient(): OkHttpClient {
            return OkHttpClient.Builder().apply {

/*                if (BuildConfig.DEBUG) {
                    addInterceptor(BaseUrlChangingInterceptorProvider.getInterceptor())
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }*/
            }.build()
        }


    }

}