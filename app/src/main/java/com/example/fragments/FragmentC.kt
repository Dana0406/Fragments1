package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentC: Fragment(R.layout.fragment_c) {
    private lateinit var goToDFromCButton: Button
    private lateinit var goToAFromCButton: Button

    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToDFromCButton = view.findViewById<Button>(R.id.goToDFromCButton)
        goToAFromCButton = view.findViewById<Button>(R.id.goToAFromCButton)

        textView = view.findViewById(R.id.textView)

        val textFromArguments = arguments?.getString(STRING_EXTRA)

        textView.text = textFromArguments

        goToDFromCButton.setOnClickListener {
            (requireActivity() as FragmentC.NextButtonClickListenerC).onNextButtonClickedC()
        }

        goToAFromCButton.setOnClickListener {
            (requireActivity() as FragmentC.NextButtonClickListenerC).onPreviousButtonClickedC()
        }
    }

    interface NextButtonClickListenerC{
        fun onNextButtonClickedC()
        fun onPreviousButtonClickedC()
    }

    companion object{
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        private const val STRING_EXTRA = "Hello Fragment C"

        fun newInstance(s: String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString(STRING_EXTRA,s)
            }
        }
    }
}