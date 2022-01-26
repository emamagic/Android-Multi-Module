package com.emamagic.core.extension

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.R

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
        .load(imageUrl).into(imageView)
}

@BindingAdapter("rank")
fun setRank(textView: TextView, rank: String?) {
    if (rank.isNullOrEmpty()) {
        textView.visibility = View.INVISIBLE
    } else {
        textView.visibility = View.VISIBLE
        textView.text = "Rank:$rank"
    }
}

@BindingAdapter("imageTime")
fun setTimeImage(imageView: ImageView, @MovieCategory category: String) {
    if (category == MovieCategory.SERIES) {
        imageView.setImageResource(R.drawable.ic_folder_special)
    } else {
        imageView.setImageResource(R.drawable.ic_access_time)
    }
}

@BindingAdapter("isFavorite")
fun setIsFavorite(imageView: ImageView, isFavorite: Boolean) {
    if (isFavorite) {
        imageView.setImageResource(R.drawable.ic_favorite_fill)
    } else {
        imageView.setImageResource(R.drawable.ic_favorite_empty)
    }
}
