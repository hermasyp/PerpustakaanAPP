package id.dev.catnip.perpustakaanapp.Networking

import id.dev.catnip.perpustakaanapp.BuildConfig
import id.dev.catnip.perpustakaanapp.Model.Books.BooksItem
import id.dev.catnip.perpustakaanapp.Model.Books.BooksResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by herma on 03-Feb-18.
 */
interface APIInterface {
    @GET("perpus")
    fun getBooks(): Call<BooksResponse>

    @GET("perpus/{id}")
    fun getBooksByID(@Path("id") page :Int): Call<BooksResponse>

    @POST("perpus")
    fun postBook(@Body booksItem: BooksItem): Call<BooksResponse>

    @DELETE("perpus/{id}")
    fun deleteBook(@Path("id") page :Int): Call<BooksResponse>

    @PUT("perpus/{id}")
    fun updateBook(@Path("id") page :Int,@Body booksItem: BooksItem): Call<BooksResponse>


    companion object Factory {
        val BASE_URL = BuildConfig.URI
        fun create(): APIInterface {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(APIInterface::class.java)
        }
    }
}