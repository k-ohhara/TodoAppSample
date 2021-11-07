package com.websarva.wings.android.todoappsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CreateTodoViewModel : ViewModel() {

    /** データリスト */
    private val dataList by lazy { ArrayList<Todo>() }

    /** 値を設定するLiveData */
    private val _items = MutableLiveData<List<Todo>>()

    /** LiveData */
    val items: LiveData<List<Todo>> = _items

    /** タスク名 */
    var taskName = MutableLiveData("")

    /** 期限 */
    var expired = MutableLiveData("")

    /** メモ */
    var description = MutableLiveData("")

    /**
     * 作成ボタン押下時
     */
    fun onCreateButtonClick() {
        Log.d("CreateTodoViewModel", "onCreateButtonClick")
        val taskNameVal = taskName.value ?: ""
        val expiredVal = expired.value ?: ""
        val format = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN)
        val descriptionVal = description.value ?: ""
        dataList.add(Todo(0, taskNameVal, "", "", expiredVal, descriptionVal, 0))
        _items.value = dataList
        // 入力された値をログ出力
        Log.d("CreateTodoViewModel", "タスク名：${taskNameVal}")
        Log.d("CreateTodoViewModel", "期限：${format.format(expiredVal)}")
        Log.d("CreateTodoViewModel", "メモ：${descriptionVal}")
        // アクティビティ終了
        val createTodoActivity = CreateTodoActivity.newInstance()
        createTodoActivity.finish()
    }

}
