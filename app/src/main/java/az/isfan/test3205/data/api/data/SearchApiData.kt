package az.isfan.test3205.data.api.data

data class SearchApiData(
    val items: List<ItemApiData>,
    val errors: List<ErrorApiData>,
)