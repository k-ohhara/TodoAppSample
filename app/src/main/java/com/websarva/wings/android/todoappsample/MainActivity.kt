package com.websarva.wings.android.todoappsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
