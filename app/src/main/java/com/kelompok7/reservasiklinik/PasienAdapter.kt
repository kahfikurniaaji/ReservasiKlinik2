package com.kelompok7.reservasiklinik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PasienAdapter(private val list: ArrayList<PasienModel>) :
    RecyclerView.Adapter<PasienAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasienAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_pasien, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(list[position])
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
//        val name=view.tv
    }
}