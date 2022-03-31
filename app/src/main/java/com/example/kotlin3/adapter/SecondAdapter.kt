package com.example.kotlin3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin3.databinding.ItemGoatBinding

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    private var list = arrayListOf<Int>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Int>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private var binding: ItemGoatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(i: Int) {
            binding.imageView.setImageResource(i)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGoatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}