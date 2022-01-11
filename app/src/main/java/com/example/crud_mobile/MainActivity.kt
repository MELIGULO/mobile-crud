package com.example.crud_mobile

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val musik_id: ArrayList<String>      = arrayListOf()
    val musik_judul: ArrayList<String>   = arrayListOf()
    val musik_pencipta: ArrayList<String> = arrayListOf()
    val musik_genre: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTambah = findViewById<FloatingActionButton>(R.id.float_add)
        btnTambah.setOnClickListener {
            val intentKita = Intent(this, TambahMusikActivity::class.java)
            startActivity(intentKita)
        }
        simpanDataDiArray()
        val musikAdapter = MusikAdapter(this,musik_id,musik_judul,musik_pencipta,musik_genre)
        val rv_musik = findViewById<RecyclerView>(R.id.rv_musik)
        rv_musik.adapter = musikAdapter
        rv_musik.layoutManager = LinearLayoutManager(this)
        rv_musik.itemAnimator = DefaultItemAnimator()
    }
    fun simpanDataDiArray(){
        val dbSaya            = MyDBHelper(this)
        val dataSaya: Cursor = dbSaya.BacaSemuaData()

        if(dataSaya.count == 0){
            Toast.makeText(this,"Data Tidak Ada!", Toast.LENGTH_SHORT).show()
        }
        else{
            while (dataSaya.moveToNext()){
                musik_id.add(dataSaya.getString(0))
                musik_judul.add(dataSaya.getString(1))
                musik_pencipta.add(dataSaya.getString(2))
                musik_genre.add(dataSaya.getString(3))
            }
        }
    }
}