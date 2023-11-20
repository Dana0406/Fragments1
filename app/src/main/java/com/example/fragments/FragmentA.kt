package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA: Fragment(R.layout.fragment_a) {
    private lateinit var goToBFromAButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToBFromAButton = view.findViewById<Button>(R.id.goToBFromAButton)

        goToBFromAButton.setOnClickListener{
            (requireActivity() as NextButtonClickListenerA).onNextButtonClickedA()
        }
    }

    interface NextButtonClickListenerA{
        fun onNextButtonClickedA()
    }

    companion object{
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        fun newInstance() = FragmentA()
    }
}