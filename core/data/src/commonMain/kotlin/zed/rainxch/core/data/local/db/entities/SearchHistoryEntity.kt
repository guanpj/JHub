package zed.rainxch.core.data.local.db.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "search_history")
data class SearchHistoryEntity(
    @PrimaryKey
    val query: String,
    val searchedAt: Long,
)
