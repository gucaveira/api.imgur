package com.example.imgur.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imgur.R
import com.example.imgur.databinding.ItemImgurListBinding

class AdapterImage(
    private val imageList: List<String>
) : RecyclerView.Adapter<AdapterImage.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        return holder.bind(imageList[position])
    }

    override fun getItemCount() = imageList.size

    class CustomViewHolder private constructor(itemBinding: ItemImgurListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val imageCategory: ImageView = itemBinding.Image

        fun bind(image: String) {
            Glide.with(imageCategory.rootView)
                .load(image)
                .placeholder(R.drawable.ic_placeholder_img)
                .fallback(R.drawable.ic_placeholder_img_error)
                .into(imageCategory)
        }

        companion object {
            fun create(parent: ViewGroup): CustomViewHolder {
                val itemBinding = ItemImgurListBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return CustomViewHolder(itemBinding)
            }
        }
    }
}