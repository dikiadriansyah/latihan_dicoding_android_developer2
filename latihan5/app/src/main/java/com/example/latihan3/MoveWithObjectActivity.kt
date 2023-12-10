package com.example.latihan3

import android.os.Build

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObjek: TextView = findViewById(R.id.tv_object_diterima)

        val person = if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
            /*
            Melalui getIntent().getParcelableExtra(Key), Anda dapat mengambil nilai objek person
            yang sebelumnya telah dikirim hanya dengan satu variabel. Bayangkan jika tidak
            menggunakan Parcelable, pasti kita perlu mengirim data satu per satu. Jika datanya
            sedikit mungkin tidak masalah, tetapi jika datanya puluhan, tentu akan merepotkan
             */
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)

        }

//        EXTRA_PERSON merupakan variabel static bertipe data string dan bernilai “extra_person”.
//        Berfungsi sebagai key untuk mendapatkan value data yang dikirim.

        if(person != null){
            val text = "Nama: ${person.nama.toString()},  \nEmail: ${person.email}, \nUmur: ${person.umur}, \nLocation: ${person.kota}"
            tvObjek.text = text
            /*
             menampilkan data objek yang sudah diterima
             */
        }

    }
}