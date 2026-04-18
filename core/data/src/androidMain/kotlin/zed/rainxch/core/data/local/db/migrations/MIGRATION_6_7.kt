package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_6_7 =
    object : Migration(6, 7) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL(
                """
                CREATE TABLE IF NOT EXISTS search_history (
                    query TEXT NOT NULL PRIMARY KEY,
                    searchedAt INTEGER NOT NULL
                )
                """.trimIndent(),
            )
        }
    }
