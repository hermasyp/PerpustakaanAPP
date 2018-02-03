package id.dev.catnip.perpustakaanapp.Model.Books

import com.google.gson.annotations.SerializedName

data class BooksItem(

	@field:SerializedName("Stok_Buku")
	val stokBuku: Int? = null,

	@field:SerializedName("Pengarang_buku")
	val pengarangBuku: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("Deskripsi_buku")
	val deskripsiBuku: String? = null,

	@field:SerializedName("judul_buku")
	val judulBuku: String? = null
)