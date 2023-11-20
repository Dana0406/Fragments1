package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentD: Fragment(R.layout.fragment_d)  {
    private lateinit var goToBFromDButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToBFromDButton = view.findViewById<Button>(R.id.goToBFromDButton)

        goToBFromDButton.setOnClickListener{
            (requireActivity() as FragmentD.NextButtonClickListenerD).onPreviousButtonClickedD()
        }

    }

    interface NextButtonClickListenerD{
        fun onPreviousButtonClickedD()
    }

    companion object{
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        fun newInstance() = FragmentD()
    }
}