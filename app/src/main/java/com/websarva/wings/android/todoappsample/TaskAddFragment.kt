package com.websarva.wings.android.todoappsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.websarva.wings.android.todoappsample.databinding.FragmentTaskAddBinding

/**
 * タスク作成画面のフラグメント
 */
class TaskAddFragment : Fragment() {

    /** ViewDataBinding */
    private lateinit var binding: FragmentTaskAddBinding

    /** CreateTodoViewModelクラス */
    private val mTaskAddViewModel: TaskAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Viewのinflate
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_add, container, false)

        //ViewとViewModelとを紐づける
        binding.taskAddViewModel = mTaskAddViewModel

        return binding.root
    }

    companion object {
        fun newInstance() = TaskAddFragment()
    }
}
