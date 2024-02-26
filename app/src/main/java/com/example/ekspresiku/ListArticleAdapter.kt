// ListArticleAdapter.kt
package com.example.ekspresiku

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecyclerview.R

class ListArticleAdapter(private val listArticle: ArrayList<Article>) : RecyclerView.Adapter<ListArticleAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_article, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, photo) = listArticle[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvTitle.text = title
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            // Membuat Intent untuk membuka ArticleDetail
            val intent = Intent(holder.itemView.context, ArticleDetailActivity::class.java)

            // Mengirim data hero yang diklik ke ArticleDetail
            intent.putExtra("ARTICLE_DATA", listArticle[position])

            // Menjalankan ArticleDetail
            holder.itemView.context.startActivity(intent)
        }

        // Menambahkan onClickListener untuk btnShowName
        holder.btnShowName.setOnClickListener {
            showName(listArticle[position].title, holder.itemView.context)
        }
    }

    private fun showName(title: String, context: Context) {
        Toast.makeText(context, "Judul Berita: $title", Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int = listArticle.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

        // Menambahkan Button ke dalam ViewHolder
        val btnShowName: Button = itemView.findViewById(R.id.btnShowName)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Article)
    }
}
