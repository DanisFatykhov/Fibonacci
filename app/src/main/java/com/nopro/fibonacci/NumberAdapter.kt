package com.nopro.fibonacci

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nopro.fibonacci.databinding.ListItemBinding

class NumberAdapter(private val context: Context, private var numbersItemList: ArrayList<Int>): RecyclerView.Adapter<NumberAdapter.ListItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val row = position / 2
        val column = position % 2
        if ((row + column) % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.gray))
        } else holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.white))

        val numberItem = numbersItemList[position]
        holder.bind(numberItem)
    }

    override fun getItemCount() = numbersItemList.size

    class ListItemViewHolder(listItemBinding: ListItemBinding): RecyclerView.ViewHolder(listItemBinding.root) {
        private val binding = listItemBinding

        fun bind(numberItem: Int) {
            binding.txtNumber.text = numberItem.toString()
        }
    }

    fun updateList(newList: List<Int>) {
        numbersItemList.addAll(newList)
        notifyDataSetChanged()
    }

}