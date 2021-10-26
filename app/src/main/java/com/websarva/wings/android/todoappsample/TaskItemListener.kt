package com.websarva.wings.android.todoappsample

interface TaskItemListener {
    /**
     * 編集アイコン押下時
     */
    fun onEditIconClick(task: Todo)

    /**
     * チェックアイコン押下時
     */
    fun onCheckIconClick(task: Todo)
}
