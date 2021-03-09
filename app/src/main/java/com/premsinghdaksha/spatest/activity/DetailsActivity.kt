package com.premsinghdaksha.spatest.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.premsinghdaksha.spatest.R
import com.premsinghdaksha.spatest.newModel.BookingsItem
import kotlinx.android.synthetic.main.activity_details.*
import java.util.*

class DetailsActivity : AppCompatActivity() {
    var list: List<BookingsItem?> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val isBookingAccepted = intent.getStringExtra("isBookingAccepted")
        val bookingEndsInTime = intent.getStringExtra("bookingEndsInTime")
        val name = intent.getStringExtra("name")
        val fullName = intent.getStringExtra("fullName")
        val mobileNumber = intent.getStringExtra("mobileNumber")
        val city = intent.getStringExtra("city")
        val state = intent.getStringExtra("state")

        tx1_d.setText(isBookingAccepted)
        tx2_d.setText(bookingEndsInTime)
        tx3_d.setText(name)
        tx4_d.setText(fullName)
        tx5_d.setText(mobileNumber)
        tx6_d.setText(city)
        tx7_d.setText(state)

    }
}