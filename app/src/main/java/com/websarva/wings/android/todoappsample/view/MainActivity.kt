package com.websarva.wings.android.todoappsample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.todoappsample.R
import com.websarva.wings.android.todoappsample.view.main.TodoListFragment

/**
 * MainActivity
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // このアクティビティに未完成タスク一覧のフラグメントを表示する
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, TodoListFragment.newInstance())
        }.commit()
    }
}
