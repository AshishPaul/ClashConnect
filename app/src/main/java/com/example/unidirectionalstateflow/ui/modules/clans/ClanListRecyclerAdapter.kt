/*
 * Copyright (c) Ashish , 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unidirectionalstateflow.ui.modules.clans

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.ui.components.BindableAdapter
import kotlinx.android.synthetic.main.list_item_clan.view.*

class ClanListRecyclerAdapter
    : RecyclerView.Adapter<ClanListRecyclerAdapter.ViewHolder>(), BindableAdapter<List<Clan>> {

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
        holder.idTextView.text = item.id
        holder.nameTextView.text = item.name
    }

    override fun getItemCount(): Int = clanList.size

    override fun setData(data: List<Clan>?) {
        data?.let {
            clanList = it
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val idTextView: TextView = mView.item_number
        val nameTextView: TextView = mView.name

        override fun toString(): String {
            return super.toString() + " '" + nameTextView.text + "'"
        }
    }
}