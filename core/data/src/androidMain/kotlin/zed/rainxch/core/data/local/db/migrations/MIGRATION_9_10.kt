package zed.rainxch.core.data.local.db.migrations

import androidx.room3.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.executeSQL

/**
 * Adds per-app monorepo tracking fields to the installed_apps table:
 *  - assetFilterRegex: optional regex applied to asset (file) names
 *  - fallbackToOlderReleases: when true, the update checker walks backwards
 *    through past releases until it finds one whose assets match the filter
 *
 * Both columns default to nullable / false so existing rows are unaffected.
 */
val MIGRATION_9_10 =
    object : Migration(9, 10) {
        override suspend fun migrate(connection: SQLiteConnection) {
            connection.executeSQL("ALTER TABLE installed_apps ADD COLUMN assetFilterRegex TEXT")
            connection.executeSQL(
                "ALTER TABLE installed_apps ADD COLUMN fallbackToOlderReleases INTEGER NOT NULL DEFAULT 0",
            )
        }
    }
