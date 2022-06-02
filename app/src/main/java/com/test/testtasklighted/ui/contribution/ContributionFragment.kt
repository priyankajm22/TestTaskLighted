package com.test.testtasklighted.ui.contribution

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.testtasklighted.databinding.FragmentContributionBinding

class ContributionFragment : Fragment() {

    private lateinit var contributionViewModel: ContributionViewModel
    private var _binding: FragmentContributionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contributionViewModel =
            ViewModelProvider(this).get(ContributionViewModel::class.java)

        _binding = FragmentContributionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textContribution
        contributionViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}