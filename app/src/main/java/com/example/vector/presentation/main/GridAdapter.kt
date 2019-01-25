package com.example.vector.presentation.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vector.R
import kotlinx.android.synthetic.main.cell_grid.view.*


class GridAdapter(private val numbers: List<Int>,
                  private val context: Context
): RecyclerView.Adapter<GridAdapter.ViewHolder>() {



    override fun getItemCount(): Int = numbers.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_grid, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.text.text = numbers[p1].toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.text
    }
}