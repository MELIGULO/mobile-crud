package com.example.crud_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class TambahMusikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_musik)

        val txtJudul = findViewById<EditText>(R.id.txtJudul)
        val txtPencipta = findViewById<EditText>(R.id.txtPencipta)
        val txtGenree = findViewById<EditText>(R.id.txtGenre)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val dbSaya = MyDBHelper(this)
            dbSaya.tambahMusik(
                txtJudul.text.toString().trim(),
                txtPencipta.text.toString().trim(),
                txtGenree.text.toString().trim()
            )
        }

    }
}