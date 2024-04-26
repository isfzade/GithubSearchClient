package az.isfan.test3205.data.mappers

import az.isfan.test3205.data.db.entities.TokenEntity
import az.isfan.test3205.data.models.TokenData

fun TokenData.toEntity(): TokenEntity {
    return TokenEntity(
        token = token
    )
}