package id.dev.catnip.perpustakaanapp.UI.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import id.dev.catnip.perpustakaanapp.Model.Books.BooksItem
import id.dev.catnip.perpustakaanapp.R
import id.dev.catnip.perpustakaanapp.utils.DrawableText
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val book:BooksItem = intent.getParcelableExtra<BooksItem>("book")
        setValue(book)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setValue (book: BooksItem): Unit {
        txtDetailJudul.text = book.judulBuku
        txtDetailPenulis.text = book.pengarangBuku
        txtDetailDeskripsi.text = book.deskripsiBuku
        txtDetailStok.text = book.stokBuku.toString()
        txtHeader.text = book.judulBuku
        imgHeaderBuku.setImageDrawable(DrawableText.makeDrawable(book.judulBuku))
    }

}
