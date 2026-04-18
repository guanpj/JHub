package zed.rainxch.core.data.local.db.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "cache_entries")
data class CacheEntryEntity(
    @PrimaryKey
    val key: String,
    val jsonData: String,
    val cachedAt: Long,
    val expiresAt: Long,
)
