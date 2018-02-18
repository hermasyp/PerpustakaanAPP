package id.dev.catnip.perpustakaanapp.Adapter;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.dev.catnip.perpustakaanapp.Model.Books.BooksItem
import id.dev.catnip.perpustakaanapp.utils.DrawableText
import id.dev.catnip.perpustakaanapp.R
import kotlinx.android.synthetic.main.item_book.view.*


class BooksAdapter(var mContext: Context, var items: List<BooksItem>?, val itemClick: (BooksItem) -> Unit) : RecyclerView.Adapter<BooksAdapter.VHBook>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHBook {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return VHBook(view, itemClick)
    }

    fun setData(newDataSet: MutableList<BooksItem>) {
        items = newDataSet.toList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VHBook, position: Int) {
        holder.bindView(items!![position])
    }

    override fun getItemCount(): Int = items!!.size ?: 0

    class VHBook(val view: View, val itemClick: (BooksItem) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindView(item: BooksItem) {
            with(item) {
                itemView.txtJudulBuku.text = item.judulBuku
                itemView.txtPenulisBuku.text = item.pengarangBuku
                itemView.setOnClickListener { itemClick(this) }
                itemView.imgItem.setImageDrawable(DrawableText.makeDrawable(item.judulBuku))
            }

        }
    }



}