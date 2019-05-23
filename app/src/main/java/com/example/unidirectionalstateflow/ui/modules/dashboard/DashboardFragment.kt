package com.example.unidirectionalstateflow.ui.modules.dashboard

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextSwitcher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.unidirectionalstateflow.R
import com.example.unidirectionalstateflow.ui.BaseFragment
import com.zerogravity.myapplication.ui.modules.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*


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

//        text_Switcher = view!!.findViewById(R.clanId.textSwitcher)
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
