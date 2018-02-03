package id.dev.catnip.perpustakaanapp.Model.Books

import com.google.gson.annotations.SerializedName

data class BooksResponse(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("Books")
	val books: List<BooksItem?>? = null
)