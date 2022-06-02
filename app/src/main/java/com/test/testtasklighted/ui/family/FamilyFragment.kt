package com.test.testtasklighted.ui.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.testtasklighted.databinding.FragmentFamilyBinding

class FamilyFragment : Fragment() {

    private lateinit var familiyViewModel: FamiliyViewModel
    private var _binding: FragmentFamilyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        familiyViewModel =
            ViewModelProvider(this).get(FamiliyViewModel::class.java)

        _binding = FragmentFamilyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFamily
        familiyViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}