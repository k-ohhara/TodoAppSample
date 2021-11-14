package com.websarva.wings.android.todoappsample.appif

/**
 * タスクのデータクラス
 *
 * @param taskId タスクID
 * @param taskName タスク名
 * @param createdAt 登録日
 * @param updatedAt 完了日
 * @param expired 期限
 * @param description メモ
 * @param status ステータス 0:未完了 1:完了
 */
data class Todo(
    val taskId: Int,
    val taskName: String,
    val createdAt: String,
    val updatedAt: String,
    val expired: String,
    val description: String,
    val status: Int
)
