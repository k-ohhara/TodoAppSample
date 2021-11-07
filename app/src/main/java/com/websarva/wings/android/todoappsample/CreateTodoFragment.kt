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

    companion object {
        fun newInstance() = CreateTodoFragment()
    }
}
