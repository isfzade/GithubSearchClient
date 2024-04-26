package az.isfan.test3205.data.mappers

import az.isfan.test3205.data.db.entities.DownloadEntity
import az.isfan.test3205.data.models.DownloadData

fun DownloadEntity.toData(): DownloadData {
    return DownloadData(
        owner = owner,
        repoName = repo,
    )
}