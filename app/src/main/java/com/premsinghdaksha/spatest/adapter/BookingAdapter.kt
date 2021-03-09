package com.premsinghdaksha.spatest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.premsinghdaksha.spatest.R
import com.premsinghdaksha.spatest.newModel.BookingsItem
import kotlinx.android.synthetic.main.item_layout.view.*

class BookingAdapter(
    var context: Context,
    var list: List<BookingsItem?>,
    var myItemClickListener: MyItemClickListener
) : RecyclerView.Adapter<BookingAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tx1.text = list.get(position)?.bookingDetail?.id.toString()
        holder.itemView.tx2.text = list.get(position)?.bookingDetail?.isBookingAccepted.toString()
        holder.itemView.tx3.text = list.get(position)?.bookingDetail?.bookingEndsInTime.toString()
        holder.itemView.tx4.text =
            list.get(position)?.bookingDetail?.services?.get(0)?.name.toString()
        holder.itemView.tx5.text = list.get(position)?.userDetail?.fullName.toString()
        holder.itemView.tx6.text = list.get(position)?.userDetail?.mobileNumber.toString()


        holder.itemView.tx6.text = list.get(position)?.location?.city.toString()
        holder.itemView.tx7.text = list.get(position)?.location?.state.toString()


        holder.itemView.cardClick.setOnClickListener {
            list.get(position)?.let { it1 -> myItemClickListener.onItemClick(position, it1) }
        }

        holder.itemView.img.setOnClickListener {
            // myItemClickListener.deleteItemOnClick(position)
             notifyItemRemoved(position)
            //notifyItemRangeChanged(position, list.size)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface MyItemClickListener {
        fun onItemClick(pos: Int,booking:BookingsItem)
        fun deleteItemOnClick(pos: Int)
    }
}

