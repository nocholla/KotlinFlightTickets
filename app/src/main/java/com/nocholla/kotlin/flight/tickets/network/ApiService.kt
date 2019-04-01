package com.nocholla.kotlin.flight.tickets.network

import com.nocholla.kotlin.flight.tickets.network.model.Price
import com.nocholla.kotlin.flight.tickets.network.model.Ticket
import java.util.List
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("airline-tickets.php")
    fun searchTickets(@Query("from") from: String, @Query("to") to: String): Single<List<Ticket>>

    @GET("airline-tickets-price.php")
    fun getPrice(@Query("flight_number") flightNumber: String, @Query("from") from: String, @Query("to") to: String): Single<Price>

}