package com.example.unidirectionalstateflow.ui.modules.clans

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.data.model.Clan
import com.example.unidirectionalstateflow.ui.components.BindableAdapter
import kotlinx.android.synthetic.main.list_item_clan.view.*

class ClanListRecyclerAdapter
    : RecyclerView.Adapter<ClanListRecyclerAdapter.ViewHolder>(), BindableAdapter<ClanListViewState> {

    interface ClanListInteractionListener {
        fun onItemClick()
    }

    private lateinit var clanListInteractionListener: ClanListInteractionListener


    private var clanList: List<Clan> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_clan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = clanList[position]
        holder.idTextView.text = item.id.toString()
        holder.nameTextView.text = item.name

        /*with(holder.mView) {
            tag = item
            setOnClickListener()
        }*/
    }

    override fun getItemCount(): Int = clanList.size

    override fun setData(data: ClanListViewState?) {
        data?.let {
            clanList = it.adapterList
            notifyDataSetChanged()
        }
    }


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val idTextView: TextView = mView.item_number
        val nameTextView: TextView = mView.name

        override fun toString(): String {
            return super.toString() + " '" + nameTextView.text + "'"
        }
    }


}