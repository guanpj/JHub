package zed.rainxch.core.data.local.db.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "starred_repos")
data class StarredRepositoryEntity(
    @PrimaryKey
    val repoId: Long,
    val repoName: String,
    val repoOwner: String,
    val repoOwnerAvatarUrl: String,
    val repoDescription: String?,
    val primaryLanguage: String?,
    val repoUrl: String,
    val stargazersCount: Int,
    val forksCount: Int,
    val openIssuesCount: Int,
    val isInstalled: Boolean = false,
    val installedPackageName: String? = null,
    val latestVersion: String?,
    val latestReleaseUrl: String?,
    val starredAt: Long?,
    val addedAt: Long,
    val lastSyncedAt: Long,
)
