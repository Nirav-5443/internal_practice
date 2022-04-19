package com.example.internal_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item_view.view.*

class PersonAdapter(val context : Context, var arr : ArrayList<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): PersonViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.card_item_view,parent,false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(arr[position])
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    class PersonViewHolder(var view : View) : RecyclerView.ViewHolder(view) {
        fun bind(p : Person) {
            view.txtID.setText(p.id.toString())
            view.txtName.setText(p.name)
            view.txtAge.setText(p.age.toString())
        }
    }

}