package com.websarva.wings.android.todoappsample.view.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.websarva.wings.android.todoappsample.R
import com.websarva.wings.android.todoappsample.databinding.FragmentTodoListBinding
import com.websarva.wings.android.todoappsample.util.TodoAdapter
import com.websarva.wings.android.todoappsample.view.detail.TaskActivity
import com.websarva.wings.android.todoappsample.viewmodel.TaskAddViewModel
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * 未完成タスクの一覧を表示するフラグメント
 */
class TodoListFragment : Fragment() {

    /** ViewDataBinding */
    private lateinit var binding: FragmentTodoListBinding

    /** CreateTodoViewModelクラス */
    private val mTaskAddViewModel: TaskAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Viewのinflate
        binding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_todo_list, container, false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // タスク追加ボタン押下時
        addTodoButton.setOnClickListener {
            // タスク作成画面へ遷移する
            startActivity(Intent(context, TaskActivity::class.java))
        }

        with(binding) {
            createTodoViewModel = mTaskAddViewModel
            todoListView.adapter = TodoAdapter(ArrayList(0))
            lifecycleOwner = this@TodoListFragment
            (createTodoViewModel as TaskAddViewModel).items.observe(viewLifecycleOwner, {
                val adapter = todoListView.adapter as TodoAdapter
                adapter.updateItems(it)
            })
        }

    }

    companion object {
        fun newInstance() = TodoListFragment()
    }

}
