package az.isfan.test3205.data.db.repos

import az.isfan.test3205.data.db.dao.DownloadDao
import az.isfan.test3205.data.db.entities.DownloadEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DownloadRepo @Inject constructor(
    private val dao: DownloadDao
): DownloadRepoInterface {
    override suspend fun insert(download: DownloadEntity) {
        dao.insert(download)
    }

    override suspend fun getDownloads(): List<DownloadEntity> {
        return dao.getDownloads()
    }
}