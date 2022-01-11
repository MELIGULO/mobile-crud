package com.example.crud_mobile

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class UbahMusikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_musik)

        val actionBar =supportActionBar
        if (intent.hasExtra("judul")) {
            actionBar?.title = intent.getStringExtra("judul")
        }

        val btnUbah = findViewById<Button>(R.id.btn_ubah)

        getIntentData()

        btnUbah.setOnClickListener {
            val dbKita = MyDBHelper(this)

            val idMusik = intent.getStringExtra("id")
            val judulMusik = findViewById<EditText>(R.id.txt_judul).text.toString()
            val penciptaMusik = findViewById<EditText>(R.id.txt_pencipta).text.toString()
            val genreMusik = findViewById<EditText>(R.id.txt_genre).text.toString()

            dbKita.ubahMusik(idMusik, judulMusik, penciptaMusik, genreMusik)
        }
        val  btnHapus = findViewById<Button>(R.id.btnHapus)
        btnHapus.setOnClickListener {
            dialogKonfirmasi()
        }
    }
    fun getIntentData() {
        if (
            intent.hasExtra("id") &&
            intent.hasExtra("judul") &&
            intent.hasExtra("pencipta") &&
            intent.hasExtra("genre")
        ){

            val idmusik         = intent.getStringExtra("id")
            val judulmusik       = intent.getStringExtra("judul")
            val penciptamusik   = intent.getStringExtra("pencipta")
            val genremusik       = intent.getStringExtra("genre")

            val txtjudul = findViewById<EditText>(R.id.txt_judul)
            val txtpencipta = findViewById<EditText>(R.id.txt_pencipta)
            val txtgenre = findViewById<EditText>(R.id.txt_genre)

            txtjudul.setText(judulmusik)
            txtpencipta.setText(penciptamusik)
            txtgenre.setText(genremusik)
        } else{
            Toast.makeText(this,"Tidak Ada Data !", Toast.LENGTH_SHORT).show()
        }
    }
    fun dialogKonfirmasi(){
        val idMusik  = intent.getStringExtra("id")
        val judulMusik = intent.getStringExtra("judul")

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Delete " + judulMusik + " ?")
        alertDialog.setMessage("Apakah anda yakin menghapus " + judulMusik + " ?")

        alertDialog.setPositiveButton("iya", DialogInterface.OnClickListener{dialog, which ->
            val dbKita = MyDBHelper(this)
            dbKita.hapusMusik(idMusik)
            startActivity(Intent(this, MainActivity::class.java))
        })
        alertDialog.setNegativeButton("Tidak", DialogInterface.OnClickListener { dialog, which ->  })
        alertDialog.create().show()
    }

}