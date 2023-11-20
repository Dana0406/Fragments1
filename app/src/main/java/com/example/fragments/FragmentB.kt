package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentB: Fragment(R.layout.fragment_b) {
    private lateinit var goToCFromBButton: Button
    private lateinit var goToAFromBButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToCFromBButton = view.findViewById<Button>(R.id.goToCFromBButton)
        goToAFromBButton = view.findViewById<Button>(R.id.goToAFromBButton)

        goToCFromBButton.setOnClickListener{
            (requireActivity() as FragmentB.NextButtonClickListenerB).onNextButtonClickedB()
        }

        goToAFromBButton.setOnClickListener{
            (requireActivity() as FragmentB.NextButtonClickListenerB).onPreviousButtonClickedB()
        }

    }

    interface NextButtonClickListenerB{
        fun onNextButtonClickedB()
        fun onPreviousButtonClickedB()
    }

    companion object{
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        fun newInstance() = FragmentB()
    }

}