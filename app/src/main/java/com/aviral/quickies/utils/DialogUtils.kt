package com.aviral.quickies.utils

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.aviral.quickies.databinding.LayoutInfoDialogBinding

class DialogUtils {

    companion object {

        fun showInfoDialog(context: Context, callBack: (Boolean) -> Unit) {

            val infoDialog = Dialog(context, android.R.style.Theme_Translucent_NoTitleBar)

            val binding = LayoutInfoDialogBinding.inflate(infoDialog.layoutInflater)

            infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            infoDialog.setCancelable(false)

            infoDialog.setContentView(binding.root)

            val window = infoDialog.window
            window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
            window?.setGravity(Gravity.CENTER)

            binding.btnClose.setOnClickListener {
                infoDialog.dismiss()
                callBack(true)
            }

            infoDialog.show()

        }

    }

}