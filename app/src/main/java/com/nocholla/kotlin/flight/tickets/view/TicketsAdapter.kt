package com.nocholla.kotlin.flight.tickets.view


import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nocholla.kotlin.flight.tickets.R
import com.nocholla.kotlin.flight.tickets.network.model.Ticket
import java.util.*

class TicketsAdapter(private var context: Context?, private var ticketList: ArrayList<Ticket>) : RecyclerView.Adapter<TicketsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket = ticketList!![position]

        // Logo
        val ticketAirlineLogoUrl = ticket.airline?.logo.toString()
        Log.d("DEBUG ticket LOGO URL", ticketAirlineLogoUrl)
        Glide.with(holder.airlineLogo!!.context)
            .load(ticketAirlineLogoUrl)
            .into(holder.airlineLogo)

        // Name
        val ticketAirlineName = ticket.airline?.name.toString()
        Log.d("DEBUG ticket TITLE", ticketAirlineName)
        holder.airlineName!!.text = ticketAirlineName

        // Stops
        val ticketAirlineStops = ticket.numberOfStops.toString()
        Log.d("DEBUG ticket DESC", ticketAirlineStops)
        holder.airlineStops!!.text = ticketAirlineStops

        // Number Of Seats
        val ticketAirlineNumberOfSeats = ticket.price?.seats.toString()
        Log.d("DEBUG ticket LOCATION", ticketAirlineNumberOfSeats)
        holder.airlineNumberOfSeats!!.text = ticketAirlineNumberOfSeats

        // Departure
        val ticketAirlineDeparture = ticket.departure.toString()
        Log.d("DEBUG ticket LOCATION", ticketAirlineDeparture)
        holder.airlineDeparture!!.text = ticketAirlineDeparture

        // Arrival
        val ticketAirlineArrival = ticket.arrival.toString()
        Log.d("DEBUG ticket LOCATION", ticketAirlineArrival)
        holder.airlineArrival!!.text = ticketAirlineArrival

        // Duration
        val ticketAirlineDuration = ticket.instructions.toString()
        Log.d("DEBUG ticket LOCATION", ticketAirlineDuration)
        holder.airlineDuration!!.text = ticketAirlineDuration

        // Price
        val ticketAirlinePrice = ticket.price?.price.toString()
        Log.d("DEBUG ticket LOCATION", ticketAirlinePrice)
        holder.airlinePrice!!.text = ticketAirlinePrice

        holder.itemView.setOnClickListener {
//            var ticketIntent = Intent(context, TicketDetailsActivity::class.java)
//            ticketIntent.putExtra("logo", ticketAirlineLogoUrl)
//            ticketIntent.putExtra("name", ticketAirlineName)
//            ticketIntent.putExtra("stops", ticketAirlineStops)
//            ticketIntent.putExtra("seats", ticketAirlineNumberOfSeats)
//            ticketIntent.putExtra("departure", ticketAirlineDeparture)
//            ticketIntent.putExtra("arrival", ticketAirlineArrival)
//            ticketIntent.putExtra("duration", ticketAirlineDuration)
//            ticketIntent.putExtra("price", ticketAirlinePrice)
//
//            context!!.startActivity(ticketIntent)
        }

    }

    override fun getItemCount(): Int {
        return ticketList.size
    }

    fun setFilter(ticketModels: List<Ticket>) {
        ticketList = ArrayList()
        ticketList!!.addAll(ticketModels)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val airlineLogo = itemView.findViewById(R.id.logo) as ImageView
        val airlineName = itemView.findViewById(R.id.airline_name) as TextView
        val airlineStops = itemView.findViewById(R.id.number_of_stops) as TextView
        val airlineNumberOfSeats = itemView.findViewById(R.id.number_of_seats) as TextView
        val airlineDeparture = itemView.findViewById(R.id.departure) as TextView
        val airlineArrival = itemView.findViewById(R.id.arrival) as TextView
        val airlineDuration = itemView.findViewById(R.id.duration) as TextView
        val airlinePrice = itemView.findViewById(R.id.price) as TextView
    }

}