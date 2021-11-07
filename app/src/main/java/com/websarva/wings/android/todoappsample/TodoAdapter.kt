package com.websarva.wings.android.todoappsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.websarva.wings.android.todoappsample.databinding.ListTodoItemBinding

/**
 * タスク一覧を表示するためのアダプタークラス
 */
class TodoAdapter(private var tasks: List<Todo>) : BaseAdapter() {

    // データセットに含まれるアイテムの数を返す
    override fun getCount() = tasks.size

    // データセット内の指定された位置に関連付けられているデータ項目を返す
    override fun getItem(position: Int) = tasks[position]

    // リスト内の指定された位置に関連付けられている行IDを返す
    override fun getItemId(position: Int) = position.toLong()

    // データセット内の指定された位置にあるデータを表示するビューを返す
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding = if (convertView == null) {
            // Binding作成
            val inflater = LayoutInflater.from(parent.context)
            ListTodoItemBinding.inflate(inflater, parent, false)
        } else {
            DataBindingUtil.getBinding(convertView) ?: throw IllegalStateException()
        }

        binding.todo = getItem(position)
        // 即時バインド
        binding.executePendingBindings()

        // Viewを取り出して返却する
        return binding.root
    }

    /**
     * リストを更新する
     */
    fun updateItems(newItems: List<Todo>) {
        tasks = newItems
        // 変更の通知
        notifyDataSetChanged()
    }

}
