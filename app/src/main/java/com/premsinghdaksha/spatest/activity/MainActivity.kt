package com.premsinghdaksha.spatest.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.premsinghdaksha.spatest.R
import com.premsinghdaksha.spatest.adapter.BookingAdapter
import com.premsinghdaksha.spatest.newModel.BookingsItem
import com.premsinghdaksha.spatest.newModel.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    var list: List<BookingsItem?> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        parsing()
    }

    fun parsing() {
        val v =
            "{ \"status\": 200, \"message\": \"Success\", \"bookings\": [{ \"booking_detail\": { \"id\": 9, \"is_booking_accepted\": true, \"booking_ends_in_time\": 100, \"booking_id\": \"\", \"services\": [{ \"id\": 0, \"name\": \"Metal\" }] }, \"user_detail\": { \"id\": 1135, \"full_name\": \"Testing1 data\", \"mobile_number\": \"(152) 114-2591\", \"profile_image\": \"https://spa-developer.s3.amazonaws.com/media/default_profile_pic.png\" }, \"location\": { \"id\": 724, \"city\": \"ghaziabad\", \"state\": \"Uttar Pradesh\", \"country\": \"India\", \"address_line\": \"Unnamed Road\", \"distance\": 9.5 } },{ \"booking_detail\": { \"id\": 9, \"is_booking_accepted\": true, \"booking_ends_in_time\": 100, \"booking_id\": \"\", \"services\": [{ \"id\": 0, \"name\": \"Metal\" }] }, \"user_detail\": { \"id\": 1135, \"full_name\": \"Testing2 data\", \"mobile_number\": \"(152) 114-2591\", \"profile_image\": \"https://spa-developer.s3.amazonaws.com/media/default_profile_pic.png\" }, \"location\": { \"id\": 724, \"city\": \"ghaziabad\", \"state\": \"Uttar Pradesh\", \"country\": \"India\", \"address_line\": \"Unnamed Road\", \"distance\": 9.5 } },{ \"booking_detail\": { \"id\": 9, \"is_booking_accepted\": true, \"booking_ends_in_time\": 100, \"booking_id\": \"\", \"services\": [{ \"id\": 0, \"name\": \"Metal\" }] }, \"user_detail\": { \"id\": 1135, \"full_name\": \"Testing3 data\", \"mobile_number\": \"(152) 114-2591\", \"profile_image\": \"https://spa-developer.s3.amazonaws.com/media/default_profile_pic.png\" }, \"location\": { \"id\": 724, \"city\": \"ghaziabad\", \"state\": \"Uttar Pradesh\", \"country\": \"India\", \"address_line\": \"Unnamed Road\", \"distance\": 9.5 } },{ \"booking_detail\": { \"id\": 9, \"is_booking_accepted\": true, \"booking_ends_in_time\": 100, \"booking_id\": \"\", \"services\": [{ \"id\": 0, \"name\": \"Metal\" }] }, \"user_detail\": { \"id\": 1135, \"full_name\": \"Testing4 data\", \"mobile_number\": \"(152) 114-2591\", \"profile_image\": \"https://spa-developer.s3.amazonaws.com/media/default_profile_pic.png\" }, \"location\": { \"id\": 724, \"city\": \"ghaziabad\", \"state\": \"Uttar Pradesh\", \"country\": \"India\", \"address_line\": \"Unnamed Road\", \"distance\": 9.5 } }] }"
        try {

            val gsonBuilder = GsonBuilder()
            val gson = gsonBuilder.create()
            val responceparse = gson.fromJson(v, Response::class.java)
            val status = responceparse.status
            val message = responceparse.message
            if (status == 200) {
                list = responceparse.bookings!!
                rvlist(list)

            } else {

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun rvlist(list_: List<BookingsItem?>) {
        recyclerView.adapter = BookingAdapter(this!!, list_, object :
            BookingAdapter.MyItemClickListener {
            override fun onItemClick(pos: Int, booking: BookingsItem) {
                intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra(
                    "isBookingAccepted",
                    list_.get(pos)?.bookingDetail?.isBookingAccepted.toString()
                )
                intent.putExtra(
                    "bookingEndsInTime",
                    list_.get(pos)?.bookingDetail?.bookingEndsInTime.toString()
                )
                intent.putExtra(
                    "name",
                    list_.get(pos)?.bookingDetail?.services?.get(0)?.name.toString()
                )
                intent.putExtra("fullName", list_.get(pos)?.userDetail?.fullName.toString())
                intent.putExtra("mobileNumber", list_.get(pos)?.userDetail?.mobileNumber.toString())
                intent.putExtra("city", list_.get(pos)?.location?.city.toString())
                intent.putExtra("state", list_.get(pos)?.location?.state.toString())
                startActivity(intent)
            }

            override fun deleteItemOnClick(pos: Int) {

            }

        })
    }

    private fun Intent(
        myItemClickListener: BookingAdapter.MyItemClickListener,
        java: Class<DetailsActivity>
    ): Intent? {
        return intent

    }

    private fun showdialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
            .setMessage("Do You Want to delete this item")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
                //deleteitem(position)
            }.setNegativeButton("No") { dialogInterface, i ->
            }
        val alert = builder.create()
        alert.show()
    }

}


