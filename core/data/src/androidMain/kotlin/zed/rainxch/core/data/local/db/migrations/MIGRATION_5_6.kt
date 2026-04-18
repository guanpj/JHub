package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_5_6 =
    object : Migration(5, 6) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL(
                """
                CREATE TABLE IF NOT EXISTS seen_repos (
                    repoId INTEGER NOT NULL PRIMARY KEY,
                    repoName TEXT NOT NULL DEFAULT '',
                    repoOwner TEXT NOT NULL DEFAULT '',
                    repoOwnerAvatarUrl TEXT NOT NULL DEFAULT '',
                    repoDescription TEXT,
                    primaryLanguage TEXT,
                    repoUrl TEXT NOT NULL DEFAULT '',
                    seenAt INTEGER NOT NULL
                )
                """.trimIndent(),
            )
        }
    }
