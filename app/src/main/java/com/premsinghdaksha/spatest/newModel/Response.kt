package com.premsinghdaksha.spatest.newModel

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("bookings")
	val bookings: List<BookingsItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)