package com.premsinghdaksha.spatest.newModel

import com.google.gson.annotations.SerializedName

data class BookingDetail(

	@field:SerializedName("booking_id")
	val bookingId: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("services")
	val services: List<ServicesItem?>? = null,

	@field:SerializedName("is_booking_accepted")
	val isBookingAccepted: Boolean? = null,

	@field:SerializedName("booking_ends_in_time")
	val bookingEndsInTime: Int? = null
)