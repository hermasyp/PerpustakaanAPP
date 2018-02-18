package id.dev.catnip.perpustakaanapp.Model.Books

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BooksItem(

	@field:SerializedName("Pengarang_buku")
	val pengarangBuku: String? = null,

	@field:SerializedName("Stok_buku")
	val stokBuku: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("Judul_buku")
	val judulBuku: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("Deskripsi_buku")
	val deskripsiBuku: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString(),
			parcel.readString(),
			parcel.readString(),
			parcel.readValue(Int::class.java.classLoader) as? Int,
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(pengarangBuku)
		parcel.writeValue(stokBuku)
		parcel.writeString(updatedAt)
		parcel.writeString(judulBuku)
		parcel.writeString(createdAt)
		parcel.writeValue(id)
		parcel.writeString(deskripsiBuku)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<BooksItem> {
		override fun createFromParcel(parcel: Parcel): BooksItem {
			return BooksItem(parcel)
		}

		override fun newArray(size: Int): Array<BooksItem?> {
			return arrayOfNulls(size)
		}
	}
}