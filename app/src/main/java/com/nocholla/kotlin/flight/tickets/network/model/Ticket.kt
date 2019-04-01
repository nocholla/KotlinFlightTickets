package com.nocholla.kotlin.flight.tickets.network.model

import com.google.gson.annotations.SerializedName


abstract class Ticket {
    var from: String? = null
        internal set
    var to: String? = null
        internal set
    @SerializedName("flight_number")
    var flightNumber: String? = null
        internal set
    var departure: String? = null
        internal set
    var arrival: String? = null
        internal set
    var duration: String? = null
        internal set
    var instructions: String? = null
        internal set
    @SerializedName("stops")
    var numberOfStops: Int = 0
        internal set

    var airline: Airline? = null
        internal set

    abstract var price: Price

    override fun equals(obj: Any?): Boolean {
        if (obj === this) {
            return true
        }
        return if (obj !is Ticket) {
            false
        } else flightNumber!!.equals(obj.flightNumber!!, ignoreCase = true)
    }

    override fun hashCode(): Int {
        var hash = 3
        hash = 53 * hash + if (this.flightNumber != null) this.flightNumber!!.hashCode() else 0
        return hash
    }
}
