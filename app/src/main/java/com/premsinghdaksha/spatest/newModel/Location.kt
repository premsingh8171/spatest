package com.premsinghdaksha.spatest.newModel

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("address_line")
	val addressLine: String? = null,

	@field:SerializedName("distance")
	val distance: Double? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state")
	val state: String? = null
)