package az.isfan.test3205.data.db.repos

import az.isfan.test3205.data.db.entities.DownloadEntity

interface DownloadRepoInterface {
    suspend fun insert(download: DownloadEntity)

    suspend fun getDownloads(): List<DownloadEntity>
}