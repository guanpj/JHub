package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_8_9 =
    object : Migration(8, 9) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL(
                "ALTER TABLE installed_apps ADD COLUMN latestReleasePublishedAt TEXT",
            )
        }
    }
