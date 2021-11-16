package com.clemen.pac

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clemen.pac.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Funcionalidad link a Activity2
        binding.buttonActivity2.setOnClickListener{
            val intent = Intent(this, Activity2 :: class.java)
            startActivity(intent)
        }

        // Funcionalidad link a Activity3
        binding.buttonActivity3.setOnClickListener {
            val intent = Intent(this,Activity3 :: class.java )
            startActivity(intent)
        }

        // Funcionalidad link a Activity4
        binding.buttonActivity4.setOnClickListener {
            val intent = Intent(this, Activity4 :: class.java)
            startActivity(intent)
        }

        //Funcionalidad botones Play, Stop

        val mediaplayer = MediaPlayer.create(this, R.raw.space)

        binding.buttonPlay.setOnClickListener {
            if(mediaplayer.isPlaying){
                mediaplayer.pause()
                Toast.makeText(
                    this,
                    "Reproduccion en pause ... ",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                mediaplayer.start()
                Toast.makeText(
                    this,
                    "Reproduciendo, espera unos segundos ... ",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

        binding.buttonStop.setOnClickListener{
            mediaplayer.stop()
            mediaplayer.prepare()
            Toast.makeText(
                this,
                "Reproduccion detenida.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}