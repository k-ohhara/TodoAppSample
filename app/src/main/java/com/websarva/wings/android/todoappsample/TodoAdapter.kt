package com.websarva.wings.android.todoappsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * タスク一覧を表示するためのアダプタークラス
 */
class TodoAdapter(private val tasks: List<Todo>, private val listener: TaskItemListener) : BaseAdapter() {

    // データセットに含まれるアイテムの数を返す
    override fun getCount() = tasks.size

    // データセット内の指定された位置に関連付けられているデータ項目を返す
    override fun getItem(position: Int) = tasks[position]

    // リスト内の指定された位置に関連付けられている行IDを返す
    override fun getItemId(position: Int) = position.toLong()

    // データセット内の指定された位置にあるデータを表示するビューを返す
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // 指定した未完成タスクを取得
        val task = getItem(position)

        // 返却するビューのレイアウトを指定
        val rowView = convertView ?: LayoutInflater.from(parent.context)
            .inflate(R.layout.list_todo_item, parent, false)

        rowView.findViewById<TextView>(R.id.todoTitle).apply {
            // タスク名をセットする
            text = task.taskName
        }

        rowView.findViewById<TextView>(R.id.todoDate).apply {
            // 期限をセットする
            text = task.expired
        }

        rowView.findViewById<ImageView>(R.id.todoEdit).apply {
            // 編集アイコン押下時
            setOnClickListener {
                listener.onEditIconClick(task)
            }
        }

        rowView.findViewById<ImageView>(R.id.todoCheck).apply {
            // 完了アイコン押下時
            setOnClickListener {
                listener.onCheckIconClick(task)
            }
        }

        return rowView
    }

}
