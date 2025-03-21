package com.example.coffeeshop.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop.Domain.ItemsModel
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.ViewholderPopularBinding

class PopularAdapter(
    private val items: MutableList<ItemsModel>,
    private val context: Context
) : RecyclerView.Adapter<PopularAdapter.Viewholder>() {

    class Viewholder(val binding: ViewholderPopularBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$${items[position].price.toString()}"

        // Проверяем, что picUrl не пустой, и берём первый URL
        if (items[position].picUrl.isNotEmpty()) {
            Glide.with(context)
                .load(items[position].picUrl[0])  // Берём первую строку из списка
                .into(holder.binding.pic)
        }
    }

    override fun getItemCount(): Int = items.size
}