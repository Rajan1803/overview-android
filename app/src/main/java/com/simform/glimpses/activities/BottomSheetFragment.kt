package com.simform.glimpses.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.simform.glimpses.databinding.FragmentBottomSheetBinding
import com.simform.glimpses.viewHolders.OuterRecyclerAdapter

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val outerAdapter = OuterRecyclerAdapter()
        binding.recycletVOuter.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = outerAdapter
        }

        binding.apply {
            btnBack.setOnClickListener {
                dismiss()
            }
            btnImgCencel.setOnClickListener {
                dismiss()
            }
        }
    }

}