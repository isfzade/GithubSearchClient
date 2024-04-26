package az.isfan.test3205.download

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.core.net.toUri

class Downloader(
    private val context: Context,
): DownloaderInterface {
    private val TAG = "isf_Downloader"

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadRepo(
        title: String,
        url: String,
        token: String,
    ): Long {
        Log.i(TAG, "downloadRepo: title=$title, url=$url")

        val request = DownloadManager
            .Request(url.toUri())
            .setMimeType("application/zip")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("$title.zip")
            .addRequestHeader("Authorization", token)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "$title.zip")

        return downloadManager.enqueue(request)
    }
}