package com.example.comics.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comics.data.model.Comic
import com.example.comics.databinding.ItemListBinding

class ComicAdapter(private val comics: List<Comic>) : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int = comics.size

    inner class ComicViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comic: Comic) {
            with(binding) {
                Glide.with(root)
                    .load(comic.image)
                    .centerCrop()
                    .into(actionImage)

                actionTitle.text = comic.title
                actionSubTitle.text = comic.subtitle
            }
        }
    }
}
