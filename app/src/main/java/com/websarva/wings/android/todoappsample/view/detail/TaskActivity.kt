package com.websarva.wings.android.todoappsample.view.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.todoappsample.R

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
}
