package zed.rainxch.core.data.local.db.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import zed.rainxch.core.data.local.db.entities.CacheEntryEntity

@Dao
interface CacheDao {
    @Query("SELECT * FROM cache_entries WHERE `key` = :key AND expiresAt > :now LIMIT 1")
    suspend fun getValid(
        key: String,
        now: Long,
    ): CacheEntryEntity?

    @Query("SELECT * FROM cache_entries WHERE `key` = :key LIMIT 1")
    suspend fun getAny(key: String): CacheEntryEntity?

    @Query("SELECT * FROM cache_entries WHERE `key` LIKE :prefix || '%' AND expiresAt > :now")
    suspend fun getValidByPrefix(
        prefix: String,
        now: Long,
    ): List<CacheEntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun put(entry: CacheEntryEntity)

    @Query("DELETE FROM cache_entries WHERE `key` = :key")
    suspend fun delete(key: String)

    @Query("DELETE FROM cache_entries WHERE `key` LIKE :prefix || '%'")
    suspend fun deleteByPrefix(prefix: String)

    @Query("DELETE FROM cache_entries WHERE expiresAt <= :now")
    suspend fun deleteExpired(now: Long)

    @Query("DELETE FROM cache_entries")
    suspend fun deleteAll()
}
