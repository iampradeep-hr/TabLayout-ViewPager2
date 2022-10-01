package com.example.tab_layout_viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(
    private val images:List<Int>
):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    //hold the views together and return a view
    inner class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    //creating a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolder(view)
    }

    //binding the data to the view elements
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage=images[position]
        holder.itemView.imageView.setImageResource(currentImage)
    }

    //return the item count
    override fun getItemCount(): Int {
        return images.size
    }

}