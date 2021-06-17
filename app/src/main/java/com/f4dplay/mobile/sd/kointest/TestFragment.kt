package com.f4dplay.mobile.sd.kointest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.f4dplay.mobile.sd.kointest.databinding.FragmentTestBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class TestFragment : Fragment() {
    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        binding.btnCountUp.setOnClickListener { mainViewModel.increaseCount() }
        binding.btnCountDown.setOnClickListener { mainViewModel.decreaseCount() }
    }

    private fun initData() {
        mainViewModel.count.observe(viewLifecycleOwner) {
            activity?.runOnUiThread { binding.tvCount.text = "$it" }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}