package dev.pseudo.trainschedule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.pseudo.trainschedule.R
import dev.pseudo.trainschedule.database.TrainItem

class TrainAdapter(private val trains: List<TrainItem>) : RecyclerView.Adapter<TrainAdapter.TrainViewHolder>() {

    class TrainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvRoute: TextView = view.findViewById(R.id.tvRoute)
        val tvTimeAndDuration: TextView = view.findViewById(R.id.tvTimeAndDuration)
        val tvStation: TextView = view.findViewById(R.id.tvStation)
        val tvPrices: TextView = view.findViewById(R.id.tvPrices)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_train, parent, false)
        return TrainViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        val train = trains[position]
        holder.tvRoute.text = "${train.from} — ${train.to}"
        holder.tvTimeAndDuration.text = "${train.departureTime} — ${train.arrivalTime} (${train.duration})"
        holder.tvStation.text = train.station
        holder.tvPrices.text = train.prices
    }

    override fun getItemCount() = trains.size
}