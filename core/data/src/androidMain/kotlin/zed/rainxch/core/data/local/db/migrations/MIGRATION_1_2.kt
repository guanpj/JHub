package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

val MIGRATION_1_2 =
    object : Migration(1, 2) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL("ALTER TABLE installed_apps ADD COLUMN installedVersionName TEXT")
            connection.executeSQL("ALTER TABLE installed_apps ADD COLUMN installedVersionCode INTEGER NOT NULL DEFAULT 0")
            connection.executeSQL("ALTER TABLE installed_apps ADD COLUMN latestVersionName TEXT")
            connection.executeSQL("ALTER TABLE installed_apps ADD COLUMN latestVersionCode INTEGER")
        }
    }
