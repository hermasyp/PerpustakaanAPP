package id.dev.catnip.perpustakaanapp.UI.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import id.dev.catnip.perpustakaanapp.R
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import id.dev.catnip.perpustakaanapp.Model.Books.BookPostItem
import id.dev.catnip.perpustakaanapp.Model.Books.BooksItem
import id.dev.catnip.perpustakaanapp.Model.Response.RequestResponse
import id.dev.catnip.perpustakaanapp.Networking.APIInterface
import kotlinx.android.synthetic.main.activity_book_form.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BookFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_form)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnSave.setOnClickListener{view -> saveData()}

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

    fun saveData(): Unit {
        val stok = etxtStok.text.toString().toIntOrNull()
        val desc = etxtDeskripsi.text.toString()
        val judul = etxtJudul.text.toString()
        val penulis = etxtPenulis.text.toString()

        var book = BooksItem(judulBuku = judul,stokBuku = stok,deskripsiBuku = desc,pengarangBuku = penulis)


        val call = APIInterface.create().postBook(book)
        Log.d("Books URL", call.request().url().toString())
        call.enqueue(object : Callback<RequestResponse> {
            override fun onResponse(call: Call<RequestResponse>?, response: Response<RequestResponse>?) {
                if(response !=null ){
                    Toast.makeText(this@BookFormActivity,response.body()!!.response!!.message, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<RequestResponse>?, t: Throwable?) {
                Toast.makeText(this@BookFormActivity,"Connection Failure", Toast.LENGTH_SHORT).show()

            }
        })
    }


    fun fieldCheck(): Boolean? {
        var fieldCheck: Boolean? = true
        if (TextUtils.isEmpty(etxtJudul.getText())) {
            etxtJudul.setError("Insert this Field!")
            fieldCheck = false
        }
        if (TextUtils.isEmpty(etxtDeskripsi.getText())) {
            etxtDeskripsi.setError("Insert this Field!")
            fieldCheck = false
        }
        if (TextUtils.isEmpty(etxtPenulis.getText())) {
            etxtPenulis.setError("Insert this Field!")
            fieldCheck = false
        }
        if (TextUtils.isEmpty(etxtStok.getText())) {
            etxtStok.setError("Insert this Field!")
            fieldCheck = false
        }
        return fieldCheck
    }
}
