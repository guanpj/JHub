package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_2_3 =
    object : Migration(2, 3) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL(
                """
                CREATE TABLE starred_repos (
                    repoId INTEGER NOT NULL,
                    repoName TEXT NOT NULL,
                    repoOwner TEXT NOT NULL,
                    repoOwnerAvatarUrl TEXT NOT NULL,
                    repoDescription TEXT,
                    primaryLanguage TEXT,
                    repoUrl TEXT NOT NULL,

                    stargazersCount INTEGER NOT NULL,
                    forksCount INTEGER NOT NULL,
                    openIssuesCount INTEGER NOT NULL,

                    isInstalled INTEGER NOT NULL DEFAULT 0,
                    installedPackageName TEXT,

                    latestVersion TEXT,
                    latestReleaseUrl TEXT,

                    starredAt INTEGER,
                    addedAt INTEGER NOT NULL,
                    lastSyncedAt INTEGER NOT NULL,

                    PRIMARY KEY(repoId)
                )
                """.trimIndent(),
            )
        }
    }
