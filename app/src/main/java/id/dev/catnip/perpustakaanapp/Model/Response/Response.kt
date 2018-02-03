package id.dev.catnip.perpustakaanapp.Model.Response

import com.google.gson.annotations.SerializedName

data class Response(

		@field:SerializedName("code")
		val code: String? = null,

		@field:SerializedName("Message")
		val message: String? = null
)