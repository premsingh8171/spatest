package com.premsinghdaksha.spatest

import android.os.Parcel
import android.os.Parcelable

class TExt protected constructor(`in`: Parcel) : Parcelable {
    var id: String?
    var name: String?

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TExt?> = object : Parcelable.Creator<TExt?> {
            override fun createFromParcel(`in`: Parcel): TExt? {
                return TExt(`in`)
            }

            override fun newArray(size: Int): Array<TExt?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        id = `in`.readString()
        name = `in`.readString()
    }
}