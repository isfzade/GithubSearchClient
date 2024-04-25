package az.isfan.test3205.data.mappers

import az.isfan.test3205.data.api.data.ItemApiData
import az.isfan.test3205.data.api.data.OwnerApiData
import az.isfan.test3205.data.api.data.SearchApiData
import az.isfan.test3205.data.models.OwnerData
import az.isfan.test3205.data.models.RepoData

fun SearchApiData.toData(): List<RepoData> {
    return items.map { it.toData() }
}

fun ItemApiData.toData(): RepoData {
    return RepoData(
        name = name,
        url = url,
        description = description,
        downloadUrl = downloadUrl,
        owner = owner.toData()
    )
}

fun OwnerApiData.toData(): OwnerData {
    return OwnerData(
        name = userName,
        avatar = avatar,
    )
}