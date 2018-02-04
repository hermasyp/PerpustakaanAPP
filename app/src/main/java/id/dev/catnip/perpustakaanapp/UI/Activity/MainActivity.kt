package id.dev.catnip.perpustakaanapp.UI.Activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import id.dev.catnip.perpustakaanapp.Adapter.BooksAdapter
import id.dev.catnip.perpustakaanapp.Model.Books.BooksItem
import id.dev.catnip.perpustakaanapp.Model.Books.BooksResponse
import id.dev.catnip.perpustakaanapp.Networking.APIInterface
import id.dev.catnip.perpustakaanapp.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        Books()
    }


    fun itemClicked(book:BooksItem){
        Toast.makeText(this,book.judulBuku,Toast.LENGTH_SHORT).show()
    }
    fun Books(): Unit {
        val call = APIInterface.create().getBooks()
        Log.d("Books URL", call.request().url().toString())
        call.enqueue(object : Callback<BooksResponse> {
            override fun onResponse(call: Call<BooksResponse>?, response: Response<BooksResponse>?) {
                if(response !=null){
                    rvBooks.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvBooks.adapter =  BooksAdapter(this@MainActivity, response.body()?.books as List<BooksItem>?,{
                        itemClicked(it)
                    })
                }
            }
            override fun onFailure(call: Call<BooksResponse>?, t: Throwable?) {
                Toast.makeText(this@MainActivity,"Connection Failure",Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
