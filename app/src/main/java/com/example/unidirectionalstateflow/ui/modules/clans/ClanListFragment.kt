package com.example.unidirectionalstateflow.ui.modules.clans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.data.model.Clan
import com.example.unidirectionalstateflow.databinding.FragmentClanListBinding
import com.example.unidirectionalstateflow.ui.BaseFragment
import javax.inject.Inject

class ClanListFragment : BaseFragment(){

    private lateinit var binding: FragmentClanListBinding
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

        viewModel.viewStateLiveData.observe(this, Observer{vs -> renderViewState(vs)})
        viewModel.viewEffectLiveData.observe(this, Observer{ve -> triggerViewEffects(ve)})

        return binding.root

    }

    fun onFabClicked() {
        sendEventToViewModel(ClanListEvent.AddItemToListEvent)
    }


    private fun renderViewState(clanListViewState: ClanListViewState) {
        binding.viewState = clanListViewState
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
