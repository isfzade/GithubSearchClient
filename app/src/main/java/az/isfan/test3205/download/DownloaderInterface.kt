package az.isfan.test3205.download

interface DownloaderInterface {
    fun downloadRepo(
        title: String,
        url: String,
        token: String,
    ): Long
}