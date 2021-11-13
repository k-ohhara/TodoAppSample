package com.websarva.wings.android.todoappsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * タスク作成画面
 */
class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        // このアクティビティにタスク作成画面のフラグメントを表示する
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, TaskAddFragment.newInstance())
        }.commit()
    }

    companion object {
        fun newInstance() = TaskActivity()
    }
}
