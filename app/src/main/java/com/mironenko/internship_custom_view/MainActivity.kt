package com.mironenko.internship_custom_view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.mironenko.internship_custom_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.customLinearLayout.addItem("First item")
        mBinding.customLinearLayout.addItem("Second item")
        mBinding.customLinearLayout.addItem("Third item")
        mBinding.customLinearLayout.addItem("Forth item")
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}