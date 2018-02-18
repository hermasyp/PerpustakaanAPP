package id.dev.catnip.perpustakaanapp.Model.Books

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BookPostItem(

	@field:SerializedName("pengarang_buku")
	val pengarangBuku: String? = null,

	@field:SerializedName("stok_buku")
	val stokBuku: String? = null,

	@field:SerializedName("deskripsi_buku")
	val deskripsiBuku: String? = null,

	@field:SerializedName("judul_buku")
	val judulBuku: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pengarangBuku)
        parcel.writeString(stokBuku)
        parcel.writeString(deskripsiBuku)
        parcel.writeString(judulBuku)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookPostItem> {
        override fun createFromParcel(parcel: Parcel): BookPostItem {
            return BookPostItem(parcel)
        }

        override fun newArray(size: Int): Array<BookPostItem?> {
            return arrayOfNulls(size)
        }
    }
}