package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_3_4 =
    object : Migration(3, 4) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL(
                """
                CREATE TABLE IF NOT EXISTS cache_entries (
                    `key` TEXT NOT NULL,
                    jsonData TEXT NOT NULL,
                    cachedAt INTEGER NOT NULL,
                    expiresAt INTEGER NOT NULL,
                    PRIMARY KEY(`key`)
                )
                """.trimIndent(),
            )
        }
    }
