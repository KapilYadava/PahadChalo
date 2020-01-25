package com.example.pahadchalo.ui.register

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.pahadchalo.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment(), OnClickListener {

    private lateinit var registerViewModel: RegisterViewModel
    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_register, container, false)
//        val textView: TextView = root.findViewById(R.id.text_register)
//        registerViewModel.text.observe(this, Observer {
////            textView.text = it
//        })

        root.OwnersImage.setOnClickListener(this)

        return root
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.OwnersImage -> {
                dispatchTakePictureIntent()
            }
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            OwnersImage.setImageBitmap(imageBitmap)
        }
    }
}