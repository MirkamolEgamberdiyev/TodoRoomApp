package com.mirkamol.food.utils.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mirkamol.food.R
import com.mirkamol.food.databinding.FragmentMenuDialogBinding

class MenuDialogFragment : DialogFragment() {
    private var _binding: FragmentMenuDialogBinding? = null
    private val binding get() = _binding!!
    var kafeName = ""
    var countPerson = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                kafeName = it.get("kafeName").toString()
                countPerson = it.get("countPerson").toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getDialog()!!.window?.setBackgroundDrawableResource(R.drawable.round_corner);
        _binding = FragmentMenuDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvAddFood.setOnClickListener {
                findNavController().navigate(
                    R.id.action_menuDialogFragment_to_addFoodFragment3,
                    bundleOf("kafeName" to kafeName, "countPerson" to countPerson)
                )
                dialog!!.dismiss()
            }

            tvTake.setOnClickListener {
                findNavController().navigate(R.id.foodsFragment)
                dialog!!.dismiss()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}