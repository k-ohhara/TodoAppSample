package com.websarva.wings.android.todoappsample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    }

    companion object {
        fun newInstance() = DoneListFragment()
    }

}
