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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.data.local.db.model.Clan
import com.example.unidirectionalstateflow.databinding.FragmentClanListBinding
import com.example.unidirectionalstateflow.di.ViewModelFactory
import com.example.unidirectionalstateflow.ui.base.BaseFragment
import javax.inject.Inject

class ClanListFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var counter = 0L
    private lateinit var binding: FragmentClanListBinding
    private var listener: ClanListRecyclerAdapter.ClanListInteractionListener? = null

    interface ClanListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Clan?)
    }

    private val viewModel: ClanListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ClanListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_clan_list,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        with(binding.fragmentClanListRecyclerview) {
            layoutManager = LinearLayoutManager(context)
            adapter = ClanListRecyclerAdapter()
        }
        binding.floatingActionButton.setOnClickListener { onFabClicked() }

        viewModel.viewState.observe(this, Observer { vs -> renderViewState(vs) })
        viewModel.viewEffect.observe(this, Observer { ve -> triggerViewEffects(ve) })

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        sendEventToViewModel(ClanListEvent.LoadClanListEvent)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun onFabClicked() {
        sendEventToViewModel(
            ClanListEvent.AddClanEvent(
                Clan(
                    counter.toString(),
                    "Test $counter"
                )
            )
        )
        counter++
    }

    private fun sendEventToViewModel(event: ClanListEvent) {
        viewModel.processEvent(event)
    }

    private fun renderViewState(clanListViewState: ClanListViewState) {
        binding.viewState = clanListViewState
    }

    private fun triggerViewEffects(clanListViewEffect: ClanListViewEffect) {
        when (clanListViewEffect) {
            is ClanListViewEffect.NavigateToClanDetailsEffect ->
                Toast.makeText(requireContext(), "Go to Clan details", Toast.LENGTH_SHORT).show()
            is ClanListViewEffect.ClanAddedEffect ->
                Toast.makeText(
                    requireContext(),
                    "Clan added successfully",
                    Toast.LENGTH_SHORT
                ).show()
        }
    }
}
