package com.websarva.wings.android.todoappsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * タスク作成画面のViewModel
 */
class TaskAddViewModel : ViewModel() {

    /** ログ用タグ */
    private val tag = "TaskAddViewModel"

    /** データリスト */
    private val dataList by lazy { ArrayList<Todo>() }

    /** 値を設定するLiveData */
    private val _items = MutableLiveData<List<Todo>>()

    /** LiveData */
    val items: LiveData<List<Todo>> = _items

    /** タスク名 */
    var taskName = MutableLiveData<String>()

    /** 年 */
    var year = MutableLiveData<Int>()

    /** 月 */
    var month = MutableLiveData<Int>()

    /** 日 */
    var day = MutableLiveData<Int>()

    /** メモ */
    var description = MutableLiveData<String>()

    /**
     * 入力した日付を返却します
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 入力された日付
     */
    fun onDateChanged(year: Int, month: Int, day: Int): String {
        Log.d(tag, "onDateChanged(year:${year}_month:${month}_day:${day})")
        val yearVal = year.toString()
        val monthVal = month.toString()
        val dayVal = day.toString()
        return "$yearVal/$monthVal/$dayVal"
    }

    /**
     * 作成ボタン押下時
     */
    fun onAddButtonClick() {
        Log.d(tag, "onAddButtonClick")
        val taskNameVal = taskName.value ?: ""
        val yearVal = year.value ?: 0
        val monthVal = month.value?.plus(1) ?: 0
        val dayVal = day.value ?: 0
        val expiredVal = onDateChanged(yearVal, monthVal, dayVal)
        val descriptionVal = description.value ?: ""
        dataList.add(Todo(0, taskNameVal, "", "", expiredVal, descriptionVal, 0))
        _items.value = dataList
        // 入力された値をログ出力
        Log.d(tag, "タスク名：${taskNameVal}")
        Log.d(tag, "期限：${expiredVal}")
        Log.d(tag, "メモ：${descriptionVal}")
    }

}
