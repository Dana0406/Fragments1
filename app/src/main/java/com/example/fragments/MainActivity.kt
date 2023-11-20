package com.example.fragments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentA.NextButtonClickListenerA,
    FragmentB.NextButtonClickListenerB, FragmentC.NextButtonClickListenerC, FragmentD.NextButtonClickListenerD {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportFragmentManager.findFragmentByTag(FragmentA.FRAGMENT_A_TAG)== null){
            with(supportFragmentManager.beginTransaction()){
                replace(R.id.fragmentContainer, FragmentA.newInstance(), FragmentA.FRAGMENT_A_TAG)
                addToBackStack(FragmentA.FRAGMENT_A_TAG)
                commit()
            }
        }
    }

    override fun onNextButtonClickedA() {
       with(supportFragmentManager.beginTransaction()){
           replace(R.id.fragmentContainer, FragmentB.newInstance(),FragmentB.FRAGMENT_B_TAG)
           addToBackStack(FragmentB.FRAGMENT_B_TAG)
           commit()
       }
    }

    override fun onNextButtonClickedB() {
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.fragmentContainer, FragmentC.newInstance("Hello Fragment C"),FragmentC.FRAGMENT_C_TAG)
            addToBackStack(FragmentC.FRAGMENT_C_TAG)
            commit()
        }
    }

    override fun onPreviousButtonClickedB() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onNextButtonClickedC() {
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.fragmentContainer, FragmentD.newInstance(),FragmentD.FRAGMENT_D_TAG)
            addToBackStack(FragmentD.FRAGMENT_D_TAG)
            commit()
        }
    }

    override fun onPreviousButtonClickedC() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onPreviousButtonClickedD() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}