package com.pradnesh.trendingingit.model.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun getRepos(
        @Query("q") search: String = "trending+android",
        @Query("sort") sort: String = "star"
    ): GitResponse
}