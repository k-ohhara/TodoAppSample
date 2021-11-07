package com.websarva.wings.android.todoappsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * タスク作成画面
 */
class CreateTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)

        // このアクティビティにタスク作成画面のフラグメントを表示する
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, CreateTodoFragment.newInstance())
        }.commit()
    }

    companion object {
        fun newInstance() = CreateTodoActivity()
    }
}
