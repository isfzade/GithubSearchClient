package az.isfan.test3205.data.mappers

import az.isfan.test3205.data.db.entities.DownloadEntity
import az.isfan.test3205.data.models.RepoData

fun RepoData.toEntity(): DownloadEntity {
    return DownloadEntity(
        owner = owner.name,
        repo = name,
        timestamp = System.currentTimeMillis(),
    )
}