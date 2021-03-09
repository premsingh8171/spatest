package com.premsinghdaksha.spatest.newModel

import com.google.gson.annotations.SerializedName

data class ServicesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)