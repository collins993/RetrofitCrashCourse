package io.github.collins993.retrofitcrashcourse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.collins993.retrofitcrashcourse.databinding.TodoItemBinding

class TodoAdapter: RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<MyTodo>() {
        override fun areItemsTheSame(oldItem: MyTodo, newItem: MyTodo): Boolean {

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyTodo, newItem: MyTodo): Boolean {

            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<MyTodo>
    get() = differ.currentList
    set(value) {differ.submitList(value)}

    override fun getItemCount(): Int {

        return todos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        return TodoViewHolder(TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.binding.apply {
            val todo = todos[position]
            txtTitle.text = todo.title
            checkboxDone.isChecked = todo.completed
        }
    }

}