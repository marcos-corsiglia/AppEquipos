package com.example.clase4

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.lang.reflect.Type

class Adapter(val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreElem: TextView = view.findViewById(R.id.item_nombre)
        val apodoElem: TextView = view.findViewById(R.id.item_apodo)
        val estadioElem: TextView = view.findViewById(R.id.item_estadio)
        val escudoElem: ImageView = view.findViewById(R.id.item_escudo)
        val banderaElem: ImageView = view.findViewById(R.id.item_bandera)


        fun bind (equipo: Equipo) {
            nombreElem.text = equipo.nombre
            apodoElem.text = equipo.apodo.toString()
            estadioElem.text = equipo.estadio.toString()


            Glide.with(context).load(equipo.escudo).into(escudoElem)

            val image = when(equipo.pais) {
                Pais.Argentina -> R.drawable.banderaargentina
                Pais.Brasil -> R.drawable.banderabrasil
                Pais.Chile -> R.drawable.banderachile
                Pais.Colombia -> R.drawable.banderacolombia
                else -> R.drawable.banderauruguay
            }

            banderaElem.setImageResource(image)

            view.setOnClickListener() {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}