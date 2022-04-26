package com.example.cocktailusingcoroutines

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class MainAdapter(
    private var mContext: Context?,
    private var drinksData: List<Drink>
) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    fun setUpdateData(items: ArrayList<Drink>) {
        this.drinksData = items

        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val category = itemView.findViewById<TextView>(R.id.tvCategory)
        val image = itemView.findViewById<ImageView>(R.id.ivThumb)
        val detail = itemView.findViewById<TextView>(R.id.tvInstructions)


    }


    override fun onBindViewHolder(holder: MainAdapter.ItemViewHolder, position: Int) {

        if (position == 9) {
            holder.category.text = drinksData[position].strCategory

            var myInstruction: String =
                "Pour all ingredients into a cocktail shaker, mix and serve over ice into a chilled glass."
            holder.detail.text = myInstruction

        }
        else{
            holder.category.text = drinksData[position].strCategory
            holder.detail.text = drinksData[position].strInstructions
        }



        mContext?.let {
            Glide.with(it).load(drinksData[position].strDrinkThumb)
                .placeholder(R.drawable.ic_drink).into(holder.image)
        }

    }

    override fun getItemCount(): Int {
        return drinksData.size


    }

}