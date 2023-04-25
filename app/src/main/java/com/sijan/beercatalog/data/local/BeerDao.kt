package com.sijan.beercatalog.data.local

import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.sijan.beercatalog.domain.Beer

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsertAll(beers: List<BeerEntity>)

    @Query("SELECT * FROM beerentity")
    //pagingSource<PageKey(like page1, page2), Each page contains just beer entities>
    fun pagingSource(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM beerentity")
    suspend fun clearAll()
}