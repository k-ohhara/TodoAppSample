package com.websarva.wings.android.todoappsample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_todo.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * タスク作成画面のフラグメント
 */
class CreateTodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // taskName
        val taskName = view.findViewById<EditText>(R.id.taskName)

        // taskExpired
        val taskExpired = view.findViewById<DatePicker>(R.id.taskExpired)
        // format
        val format = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN)

        // taskDescription
        val taskDescription = view.findViewById<EditText>(R.id.taskDescription)

        // 作成ボタン押下時
        createButton.setOnClickListener {
            // 入力された値をログ出力
            Log.d("CreateTodoFragment", "タスク名：${taskName.text}")
            Log.d("CreateTodoFragment", "期限：${format.format(taskExpired.dayOfMonth)}")
            Log.d("CreateTodoFragment", "メモ：${taskDescription.text}")
        }
    }

    companion object {
        fun newInstance() = CreateTodoFragment()
    }
}
