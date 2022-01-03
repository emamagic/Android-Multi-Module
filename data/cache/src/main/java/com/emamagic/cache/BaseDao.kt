//package com.emamagic.cache
//
//import androidx.room.*
//
//
//interface BaseDao<ENTITY> {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(item: ENTITY): Long
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(items: List<ENTITY>): List<Long>
//
//    @Delete
//    suspend fun delete(item: ENTITY)
//
//    @Update
//    suspend fun update(item: ENTITY)
//
//    @Update
//    suspend fun update(items: List<ENTITY?>)
//}
//
//
//@Transaction
//suspend inline fun <reified ENTITY> BaseDao<ENTITY>.upsert(item: ENTITY) {
//    if (insert(item) != -1L) return
//    update(item)
//}
//
//@Transaction
//suspend inline fun <reified ENTITY> BaseDao<ENTITY>.upsert(items: List<ENTITY>) {
//    val insertResult = insert(items)
//    val updateList = mutableListOf<ENTITY>()
//    for (i in insertResult.indices) {
//        if (insertResult[i] == -1L) updateList.add(items[i])
//    }
//    if (updateList.isNotEmpty()) update(updateList)
//}
//
//@Transaction
//suspend inline fun <reified ENTITY> BaseDao<ENTITY>.insertOrDelete(item: ENTITY) {
//    val insertResult = insert(item)
//    if (insertResult == -1L) delete(item)
//}
//
//
