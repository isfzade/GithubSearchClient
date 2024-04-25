package az.isfan.test3205.data.api.data

import com.google.gson.annotations.SerializedName

data class ItemApiData(
    val name: String,

    @SerializedName("html_url")
    val url: String,

    val description: String?,

    @SerializedName("downloads_url")
    val downloadUrl: String,
    val owner: OwnerApiData,
)

data class OwnerApiData(
    @SerializedName("login")
    val userName: String,
    val avatar: String,
)
