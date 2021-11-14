package com.websarva.wings.android.todoappsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.websarva.wings.android.todoappsample.appif.Todo

/**
 * 未完成タスク一覧のViewModelクラス
 */
class TodoListViewModel : ViewModel() {

    /** 値を設定するLiveData */
    private val _todoListItems = MutableLiveData<List<Todo>>()

    /** LiveData */
    val todoListItems: LiveData<List<Todo>>
        get() = _todoListItems

    /**
     * リストに表示するデータを作成してLiveDataに追加する
     */
    fun loadTodoListItems() {
        val todoList = arrayListOf(
            Todo(0, "未完了タスク１", "", "", "2020/05/21", "", 0),
            Todo(0, "未完了タスク２", "", "", "2020/05/31", "", 0),
            Todo(0, "未完了タスク３", "", "", "2020/06/21", "", 0)
        )
        _todoListItems.value = todoList
    }
}
