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

package com.example.unidirectionalstateflow.ui.modules.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.ui.base.BaseFragment
import com.zerogravity.myapplication.ui.modules.dashboard.DashboardViewModel


class DashboardFragment : BaseFragment() {


    private lateinit var viewModel: DashboardViewModel
//    private lateinit var text_Switcher: TextSwitcher
//    private val avd: AnimatedVectorDrawableCompat? by lazy {
//        AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.avd_anim)?.apply {
//            registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
//                override fun onAnimationEnd(drawable: Drawable?) {
//                    animateEqualizer()
//                }
//            })
//        }
//    }

//    private val slideUpIn: Animation by lazy {
//        AnimationUtils.loadAnimation(
//            requireContext(),
//            R.anim.slide_up_in
//        )
//    }
//    private val slideUpExit: Animation by lazy {
//        AnimationUtils.loadAnimation(
//            requireContext(),
//            R.anim.slide_up_exit
//        )
//    }
//    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)

//        text_Switcher = view!!.findViewById(R.id.textSwitcher)
//        text_Switcher.inAnimation = slideUpIn
//        text_Switcher.outAnimation = slideUpExit


//        avd?.let {
//            image.setImageDrawable(it)
//        }
//
//        animateEqualizer()
//
//        button_animation.setOnClickListener { animateText() }
    }

//    private fun animateEqualizer() = image?.post { avd?.start() }
//
//    fun animateText() {
//        counter++
//        text_Switcher.setText("animateText $counter")
//    }
}
