package com.example.vector.presentation.history

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vector.R
import com.example.vector.entity.Result
import kotlinx.android.synthetic.main.cell_history.view.*


class TableAdapter(private val results: List<Result>,
                   private val context: Context): RecyclerView.Adapter<TableAdapter.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return if(position==0) 0 else 1
    }
    override fun getItemCount(): Int = results.size + 1 //+1 to header

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return if (p1 == 0) HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_history_header, p0, false))
        else ResultViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_history, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        when(p1) {
            0 -> { /*do nothing*/ }
            else -> {
                val currentResult = results[p1-1]
                (p0 as ResultViewHolder).numberText.text = currentResult.n.toString()
                p0.resultText.text =
                        if(currentResult.existence) context.getString(R.string.result_exist) else context.getString(R.string.result_not_exist)
            }
        }
    }

    open class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    class HeaderViewHolder(itemView: View): TableAdapter.ViewHolder(itemView)
    class ResultViewHolder(itemView: View): TableAdapter.ViewHolder(itemView) {
        val resultText = itemView.result_text
        val numberText = itemView.number
    }


}