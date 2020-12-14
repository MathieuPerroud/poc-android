package org.diiage.poc.data.sources

import org.diiage.poc.domain.people.People
import retrofit2.Call
import retrofit2.http.GET

interface StarWarsAPI {

    @GET("people/")
    fun getPeoples(): Call<List<People>>
}