package zed.rainxch.core.data.local.db.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "seen_repos")
data class SeenRepoEntity(
    @PrimaryKey
    val repoId: Long,
    val repoName: String,
    val repoOwner: String,
    val repoOwnerAvatarUrl: String,
    val repoDescription: String?,
    val primaryLanguage: String?,
    val repoUrl: String,
    val seenAt: Long,
)
