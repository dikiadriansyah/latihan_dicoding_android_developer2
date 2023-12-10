package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        inisilaisasi komponen
        var etTglLahir = findViewById<EditText>(R.id.et_tanggal_lahir)
        var btKirim = findViewById<Button>(R.id.btn_kirim)
        var tvHasil = findViewById<TextView>(R.id.txtHasil)

        btKirim.setOnClickListener{
            val input = etTglLahir.text.toString() // ubah ke string
            val hasil = when(input.toInt()){
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1995 -> "Milineal"
                in 1996..2010->"Z"
            else -> "Gak Tau Bro"
            }
            tvHasil.text = "Kamu Generasi $hasil"
        }


    }
}