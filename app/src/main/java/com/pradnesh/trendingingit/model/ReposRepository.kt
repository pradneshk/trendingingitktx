package com.pradnesh.trendingingit.model

import com.pradnesh.trendingingit.model.network.ApiClient
import com.pradnesh.trendingingit.model.network.ApiService

object ReposRepository {
    suspend fun getReposList(): List<Item>{
        val response = ApiClient.searchService.getRepos()
        if(response.total_count>0 && response.items!=null)
            return response.items.map { itemResponse -> Item.fromItemResponse(itemResponse) }
        return emptyList()
    }
}