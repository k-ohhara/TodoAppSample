package com.websarva.wings.android.todoappsample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * 完了タスク一覧を表示するフラグメント
 */
class DoneListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_done_list, container, false)
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
        val task1 = Todo(0, "完了タスク１", "", "", "2020/05/21", "", 0)
        val task2 = Todo(0, "完了タスク２", "", "", "2020/05/31", "", 0)
        val task3 = Todo(0, "完了タスク３", "", "", "2020/06/21", "", 0)
        // ダミーデータのタスクをセットする
        tasks.add(task1)
        tasks.add(task2)
        tasks.add(task3)
        // リストビューを表示
        todoListView.adapter = TodoAdapter(tasks, object : TaskItemListener {
            override fun onEditIconClick(task: Todo) {
                // トースト表示
                Toast.makeText(activity, "onEditIconClick", Toast.LENGTH_SHORT).show()
            }

            override fun onCheckIconClick(task: Todo) {
                // トースト表示
                Toast.makeText(activity, "onCheckIconClick", Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        fun newInstance() = DoneListFragment()
    }

}
