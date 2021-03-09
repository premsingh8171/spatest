package com.premsinghdaksha.spatest.newModel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BookingsItem (

	@field:SerializedName("user_detail")
	val userDetail: UserDetail? = null,

	@field:SerializedName("booking_detail")
	val bookingDetail: BookingDetail? = null,

	@field:SerializedName("location")
	val location: Location? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		TODO("userDetail"),
		TODO("bookingDetail"),
		TODO("location")
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {

	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<BookingsItem> {
		override fun createFromParcel(parcel: Parcel): BookingsItem {
			return BookingsItem(parcel)
		}

		override fun newArray(size: Int): Array<BookingsItem?> {
			return arrayOfNulls(size)
		}
	}
}

