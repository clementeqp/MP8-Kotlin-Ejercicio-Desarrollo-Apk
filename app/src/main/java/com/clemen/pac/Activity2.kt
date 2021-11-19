package com.clemen.pac



import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.clemen.pac.databinding.Activity2Binding


class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    private lateinit var bbdd : AdminSQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usamos view Binding para la vinculacion de las vistas
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // Lanzamos un mensaje, para sber en que Activity estamos "..."
        Toast.makeText(
            this,
            "Estas en la Activity 2 ...",
            Toast.LENGTH_SHORT
        ).show()

        binding.button2Main.setOnClickListener {
            finish()
        }

        var databaseName = "db_pac"

        //Pulsar boton crear , creara la bbdd
        binding.buttonCrear.setOnClickListener {

            bbdd = AdminSQLiteOpenHelper(this, databaseName, null, 1)
            // Lanzamos un mensaje , "..."
            Toast.makeText(
                this,
                "Se ha creado correctamente la base de datos $databaseName",
                Toast.LENGTH_SHORT
            ).show()
            binding.tv1.setText("Base de datos : $databaseName creada con exito")


        }

        //Insertar
        binding.buttonInsertar.setOnClickListener {

            val bd = bbdd.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", binding.et5.getText().toString())
            registro.put("email", binding.et6.getText().toString())
            bd.insert("alumnos", null, registro)
            bd.close()

            // Lanzamos un mensaje , "..."
            Toast.makeText(
                this,
                "Se guardaron los datos del alumno ${binding.et5.getText().toString()}",
                Toast.LENGTH_SHORT
            ).show()
            binding.et5.setText("")
            binding.et6.setText("")

        }

        //Consultar
        binding.buttonConsul.setOnClickListener {

            val bd = bbdd.readableDatabase
            val fila = bd.rawQuery(
                "select nombre,email from alumnos where _id=${
                    binding.et2.getText().toString()
                }", null
            )
            if (fila.moveToFirst()) {
                binding.tv3.setText(fila.getString(0))
                binding.tv4.setText(fila.getString(1))
            } else
            // Lanzamos un mensaje , "..."
                Toast.makeText(
                    this,
                    "No existe un alumno con el id: " + binding.et2.getText().toString(),
                    Toast.LENGTH_SHORT
                ).show()
            bd.close()
        }


    }

}