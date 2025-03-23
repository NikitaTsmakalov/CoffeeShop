package com.example.coffeeshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop.Activity.DetailActivity
import com.example.coffeeshop.Domain.ItemsModel
import com.example.coffeeshop.databinding.ViewholderItemPicLeftBinding
import com.example.coffeeshop.databinding.ViewholderItemPicRightBinding


class ItemsListCategoryAdapter(private val items: MutableList<ItemsModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_ITEM1 = 0
        const val TYPE_ITEM2 = 1
    }

    private lateinit var context: Context

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) TYPE_ITEM1 else TYPE_ITEM2
    }

    // ViewHolder для первого типа элемента
    class ViewholderItem1(val binding: ViewholderItemPicRightBinding) : RecyclerView.ViewHolder(binding.root)

    // ViewHolder для второго типа элемента
    class ViewholderItem2(val binding: ViewholderItemPicLeftBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return when (viewType) {
            TYPE_ITEM1 -> {
                val binding = ViewholderItemPicRightBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
                ViewholderItem1(binding)
            }
            TYPE_ITEM2 -> {
                val binding = ViewholderItemPicLeftBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
                ViewholderItem2(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        // Вызов bindCommonData с нужными параметрами
        bindCommonData(
            holder,
            item.title,
            "${item.price} USD",
            item.rating.toFloat(),
            item.picUrl[0]
        )

        // Обработка клика на элемент
        holder.itemView.setOnClickListener {
            openDetailActivity(position)
        }
    }

    // Метод для привязки общих данных
    private fun bindCommonData(
        holder: RecyclerView.ViewHolder,
        titleTxt: String,
        priceTxt: String,
        rating: Float,
        picUrl: String
    ) {
        when (holder) {
            is ViewholderItem1 -> {
                holder.binding.titleTxt.text = titleTxt
                holder.binding.priceTxt.text = priceTxt
                holder.binding.ratingBar.rating = rating
                Glide.with(context)
                    .load(picUrl) // Загрузка изображения
                    .into(holder.binding.picMain)
            }
            is ViewholderItem2 -> {
                holder.binding.titleTxt.text = titleTxt
                holder.binding.priceTxt.text = priceTxt
                holder.binding.ratingBar.rating = rating
                Glide.with(context)
                    .load(picUrl) // Загрузка изображения
                    .into(holder.binding.picMain)
            }
        }
    }

    // Метод для открытия DetailActivity
    private fun openDetailActivity(position: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("object", items[position])
        context.startActivity(intent)
    }
}