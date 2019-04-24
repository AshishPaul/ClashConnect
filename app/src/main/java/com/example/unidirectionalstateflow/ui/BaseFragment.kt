package com.example.unidirectionalstateflow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.unidirectionalstateflow.di.Injectable

abstract class BaseFragment : Fragment(), Injectable {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = findNavController().currentDestination?.label
    }
}