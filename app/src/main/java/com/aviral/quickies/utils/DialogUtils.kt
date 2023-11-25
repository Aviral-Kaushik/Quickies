package com.aviral.quickies.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.aviral.quickies.databinding.LayoutInfoDialogBinding

class DialogUtils {

    companion object {

        fun showInfoDialog(context: Context) {

            val infoDialog = Dialog(context, android.R.style.Theme_Translucent_NoTitleBar)

            val binding = LayoutInfoDialogBinding.inflate(infoDialog.layoutInflater)

            infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            infoDialog.setCancelable(false)

            infoDialog.setContentView(binding.root)

            binding.btnClose.setOnClickListener { infoDialog.dismiss() }

            infoDialog.show()

        }

    }

}