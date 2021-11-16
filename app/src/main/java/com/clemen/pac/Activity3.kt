package com.clemen.pac


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast


import com.clemen.pac.databinding.Activity3Binding



class Activity3 : AppCompatActivity() {

    private lateinit var binding : Activity3Binding
    val request_capturar_img = 1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lanzamos un mensaje diciendo donde estamos
        Toast.makeText(this, "Estas en la Activity3, vamos a tomar una foto",
        Toast.LENGTH_LONG).show()


        binding.button3Main.setOnClickListener {
            finish()

        }
        binding.buttonCamara.setOnClickListener {
            tomarFoto()
        }

    }


    private fun tomarFoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { tomarFotoIntent ->
            tomarFotoIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(tomarFotoIntent, request_capturar_img)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == request_capturar_img && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
                binding.imageCamara.setImageBitmap(imageBitmap)
            }
        }


}

// https://www.youtube.com/watch?v=TRDaAAhTF1w
// https://developer.android.com/training/camera/photobasics?hl=es-419