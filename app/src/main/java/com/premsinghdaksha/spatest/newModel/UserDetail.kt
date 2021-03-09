package com.premsinghdaksha.spatest.newModel

import com.google.gson.annotations.SerializedName

data class UserDetail(

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("mobile_number")
	val mobileNumber: String? = null
)