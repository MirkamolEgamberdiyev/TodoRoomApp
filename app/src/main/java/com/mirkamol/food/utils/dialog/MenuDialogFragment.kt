package com.mirkamol.food.utils.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mirkamol.food.R
import com.mirkamol.food.databinding.FragmentMenuDialogBinding

class MenuDialogFragment(private val listener: (String) -> Unit) : DialogFragment() {
    private var _binding: FragmentMenuDialogBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.CustomDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvAddFood.setOnClickListener {
                listener.invoke("add_food")
                dismiss()
            }

            tvTake.setOnClickListener {
                listener.invoke("take_food")
                dismiss()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}