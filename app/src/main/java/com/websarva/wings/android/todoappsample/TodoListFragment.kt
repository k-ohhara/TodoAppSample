package com.websarva.wings.android.todoappsample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.websarva.wings.android.todoappsample.databinding.FragmentTodoListBinding
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * 未完成タスクの一覧を表示するフラグメント
 */
class TodoListFragment : Fragment() {

    /** ViewDataBinding */
    private lateinit var viewDataBinding: FragmentTodoListBinding

    /** TodoListViewModelクラス */
    private val todoListViewModel: TodoListViewModel by viewModels()

    /** TodoAdapterクラス */
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // タスク追加ボタン押下時
        addTodoButton.setOnClickListener {
            // タスク作成画面へ遷移する
            startActivity(Intent(context, CreateTodoActivity::class.java))
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        // ListViewにAdapterをセット
//        val todoListViewModel = viewDataBinding.todoListViewModel
//        if (todoListViewModel != null) {
//            // ViewModelがDataBindingに存在する場合のみ
//            todoAdapter = TodoAdapter(ArrayList(0))
//            viewDataBinding.todoListView.adapter = todoAdapter
//        }
//
    }

    override fun onResume() {
        super.onResume()

        // リストに表示する内容を作成
        todoListViewModel.loadTodoListItems()
    }

    companion object {
        fun newInstance() = TodoListFragment()
    }

}
