package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_7_8 =
    object : Migration(7, 8) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL(
                "ALTER TABLE installed_apps ADD COLUMN includePreReleases INTEGER NOT NULL DEFAULT 0",
            )
        }
    }
