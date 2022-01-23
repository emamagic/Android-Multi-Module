package com.emamagic.home.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.home.R

@BindingAdapter("rank")
fun setRank(textView: TextView, rank: String?) {
    if (rank.isNullOrEmpty()) {
        textView.visibility = View.INVISIBLE
    } else {
        textView.visibility = View.VISIBLE
        textView.text = "Rank:$rank"
    }
}

@BindingAdapter("timeImage")
fun setTimeImage(imageView: ImageView, @MovieCategory category: String) {
    if (category == MovieCategory.SERIES) {
        imageView.setImageResource(R.drawable.ic_folder_special)
    } else {
        imageView.setImageResource(R.drawable.ic_access_time)
    }
}