package com.example.kotlin3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin3.databinding.ItemGoatBinding

class GoatAdapter(private var onclick: OnClick) : RecyclerView.Adapter<GoatAdapter.ViewHolder>() {

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
            binding.imageView.setOnClickListener {
                binding.bg.visibility = View.VISIBLE
                onclick.click(i)
            }
            binding.bg.setOnClickListener {
                binding.bg.visibility = View.INVISIBLE
                onclick.deleteClick(i)
            }
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
        return list.size
    }

    interface OnClick {
        fun click(image: Int)
        fun deleteClick(image: Int)
    }
}