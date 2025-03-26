package com.example.week2_1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.week2_1.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 대시보드 텍스트 설정
        val textView: TextView = binding.textDashboard
        textView.text = "대시보드 프래그먼트"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
