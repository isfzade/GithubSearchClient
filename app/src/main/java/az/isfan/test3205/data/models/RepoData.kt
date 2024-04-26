package az.isfan.test3205.data.models

data class RepoData(
    val name: String,
    val url: String,
    val description: String?,
    val downloadUrl: String,
    val defaultBranch: String,
    val owner: OwnerData,
)