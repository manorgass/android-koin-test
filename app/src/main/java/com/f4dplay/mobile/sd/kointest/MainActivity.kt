package com.f4dplay.mobile.sd.kointest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.f4dplay.mobile.sd.kointest.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, TestFragment())
            .replace(binding.fragmentContainerView2.id, TestFragment())
            .commit()
    }

    private fun initData() {
        mainViewModel.count.observe(this) {
            binding.textView.text = "$it"
        }
    }
}