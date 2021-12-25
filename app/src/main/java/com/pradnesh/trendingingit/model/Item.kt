package com.pradnesh.trendingingit.model

import com.pradnesh.trendingingit.model.network.ItemResponse
import com.pradnesh.trendingingit.model.network.OwnerResponse

data class Item(
    val name: String,
    val description: String,
    val starGazersCount: Int,
    val forksCount: Int,
    val issuesCount: Int,
    val owner: Owner
) {
    companion object {
        fun fromItemResponse(itemResponse: ItemResponse): Item {
            return Item(
                name = itemResponse.full_name,
                description = itemResponse.description,
                starGazersCount = itemResponse.stargazers_count,
                forksCount = itemResponse.forks_count,
                issuesCount = itemResponse.open_issues_count,
                owner = Owner.fromOwnerResponse(itemResponse.owner)
            )
        }
    }
}

data class Owner(
    val name: String,
    val avatar_url: String
) {
    companion object {
        fun fromOwnerResponse(ownerResponse: OwnerResponse): Owner {
            return Owner(
                name = ownerResponse.login,
                avatar_url = ownerResponse.avatar_url
            )
        }
    }
}