package com.example.recyclerviewlearning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearning.databinding.FlagItemBinding

class FlagAdapter: RecyclerView.Adapter<FlagAdapter.FlagHolder>() {
    val flagList = ArrayList<Flag>()

    class FlagHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FlagItemBinding.bind(item)

        fun bind(flag: Flag) = with(binding){
            im.setImageResource(flag.imageId)
            tvTitle.text = flag.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flag_item, parent, false)
        return FlagHolder(view)
    }

    override fun onBindViewHolder(holder: FlagHolder, position: Int) {
        holder.bind(flagList[position])
    }

    override fun getItemCount(): Int {
        return flagList.size
    }

    fun addFlag(flag: Flag) {
        flagList.add(flag)
        notifyDataSetChanged()
    }
}