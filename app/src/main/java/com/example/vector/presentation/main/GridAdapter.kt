package com.example.vector.presentation.main

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vector.R
import com.example.vector.entity.Result
import kotlinx.android.synthetic.main.cell_grid.view.*


class GridAdapter(private val numbers: List<Int>,
                  private val context: Context,
                  private val resultToShow: Result? = null): RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    override fun getItemCount(): Int = numbers.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_grid, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val currentNumber = numbers[p1]
        p0.text.text = currentNumber.toString()
        resultToShow?.let {
            if (currentNumber == it.numberA || currentNumber == it.numberB) {
                p0.text.setTextColor(Color.BLUE)
                p0.text.setTypeface(p0.text.typeface, Typeface.BOLD)
            } else {
                p0.text.setTextColor(ContextCompat.getColor(context, android.R.color.tab_indicator_text))
                p0.text.setTypeface(p0.text.typeface, Typeface.NORMAL)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.text
    }
}