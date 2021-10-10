package com.websarva.wings.android.todoappsample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * 未完成タスクの一覧を表示するフラグメント
 */
class TodoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // タスク追加ボタン押下時
        addTodoButton.setOnClickListener {
            // タスク作成画面へ遷移する
            startActivity(Intent(context, CreateTodoActivity::class.java))
        }

        // TODO ダミーデータ
        val tasks = arrayListOf<Todo>()
        // ダミーデータをセットしたタスク
        val task1 = Todo(0, "未完了タスク１", "", "", "2020/05/21", "", 0)
        val task2 = Todo(0, "未完了タスク２", "", "", "2020/05/31", "", 0)
        val task3 = Todo(0, "未完了タスク３", "", "", "2020/06/21", "", 0)
        // ダミーデータのタスクをセットする
        tasks.add(task1)
        tasks.add(task2)
        tasks.add(task3)
        // リストビューを表示
        todoListView.adapter = TodoAdapter(tasks)
    }

    /**
     * 未完成タスク一覧を表示するためのアダプタークラス
     */
    private class TodoAdapter(private val tasks: List<Todo>) : BaseAdapter() {

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

            // タスク名をセットする
            rowView.findViewById<TextView>(R.id.todoTitle).apply {
                text = task.taskName
            }

            // 期限をセットする
            rowView.findViewById<TextView>(R.id.todoDate).apply {
                text = task.expired
            }

            return rowView
        }

    }

    companion object {
        fun newInstance() = TodoListFragment()
    }
}
