package id.dev.catnip.perpustakaanapp.Model.Response

import com.google.gson.annotations.SerializedName

data class RequestResponse(

	@field:SerializedName("Response")
	val response: Response? = null
)