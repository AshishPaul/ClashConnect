package com.example.unidirectionalstateflow.ui.modules.clans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.data.model.Clan
import com.example.unidirectionalstateflow.databinding.FragmentClanListBinding
import com.example.unidirectionalstateflow.ui.BaseFragment
import javax.inject.Inject

class ClanListFragment : BaseFragment(){

    private var listener: ClanListRecyclerAdapter.ClanListInteractionListener? = null

    interface ClanListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Clan?)
    }


    @Inject
    lateinit var viewModelFactory: ClanListViewModelFactory

    private val viewModel: ClanListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ClanListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentClanListBinding>(
            inflater,
            R.layout.fragment_clan_list,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        with(binding.fragmentClanListRecyclerview) {
            layoutManager = LinearLayoutManager(context)
            adapter = ClanListRecyclerAdapter()
        }
        binding.floatingActionButton.setOnClickListener { onFabClicked() }
        return binding.root

    }

    fun onFabClicked() {
        sendEventToViewModel(ClanListEvent.AddItemToListEvent)
    }


    private fun renderViewState(clanListViewState: ClanListViewState) {

    }

    private fun triggerViewEffects(clanListViewEffect: ClanListViewEffect) {
        when (clanListViewEffect) {
            is ClanListViewEffect.NavigateToClanDetailsEffect ->
                Toast.makeText(requireContext(), "Go to Clan details", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        sendEventToViewModel(ClanListEvent.ScreenLoadEvent)
    }

    private fun sendEventToViewModel(event: ClanListEvent) {
        viewModel.processInput(event)
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}
