package com.test.testtasklighted.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.test.testtasklighted.R
import com.test.testtasklighted.databinding.FragmentHomeBinding
import com.test.testtasklighted.databinding.FragmentListEventsBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val mTitleList = arrayOf("Birthdays", "Wedding Anniversary")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.vpEvents.adapter = PagerOrderAdapter(childFragmentManager)
        binding.tabsEvents.setupWithViewPager(binding.vpEvents)

        binding.rvHouseholds.layoutManager = LinearLayoutManager(activity, HORIZONTAL, false)
        binding.rvHouseholds.isNestedScrollingEnabled = false
        binding.rvHouseholds.adapter = HouseHoldsAdapter()

        val root: View = binding.root

        return root
    }


    inner class HouseHoldsAdapter : RecyclerView.Adapter<HouseHoldsAdapter.CustomViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view =
                LayoutInflater.from(activity)
                    .inflate(R.layout.item_household, parent, false)
            return CustomViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 5
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        }

        inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }


    inner class PagerOrderAdapter
        (
        fm: FragmentManager?,
    ) :
        FragmentStatePagerAdapter(fm!!) {
        override fun getPageTitle(position: Int): CharSequence? {
            return mTitleList[position]
        }

        override fun getItem(position: Int): Fragment {
             return FragmentEventList.Companion.newInstance(
                mTitleList[position]
            )
        }

         override fun getCount(): Int {
            return mTitleList.size
        }

    }


    public class FragmentEventList : Fragment() {
        private var _binding: FragmentListEventsBinding? = null

         private val binding get() = _binding!!

        companion object {

            fun newInstance(
                mTitle: String,
            ): FragmentEventList {
                val fragment: FragmentEventList =
                    FragmentEventList()
                val bundle = Bundle()
                bundle.putString("name", mTitle)
                fragment.arguments = bundle
                return fragment
            }
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View {
            _binding = FragmentListEventsBinding.inflate(inflater, container, false)

            binding.rvEvents.layoutManager = LinearLayoutManager(activity, HORIZONTAL, false)
            binding.rvEvents.isNestedScrollingEnabled = false
            binding.rvEvents.adapter = EventAdapter()

            val root: View = binding.root
            return root

        }

        inner class EventAdapter : RecyclerView.Adapter<EventAdapter.CustomViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
                val view =
                    LayoutInflater.from(activity)
                        .inflate(R.layout.item_events, parent, false)
                return CustomViewHolder(view)
            }

            override fun getItemCount(): Int {
                return 5
            }

            override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

            }

            inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}