package com.example.latihan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_data)

        val tvDataDiterima: TextView = findViewById(R.id.tv_data_diterima)
        val nama = intent.getStringExtra(EXTRA_NAME)
/*
Catatan : Key yang dikirimkan melalui putExtra() harus sama dengan key sewaktu mengambil nilai
dari data yang dikirimkan melalui getStringExtra().

Dalam konteks di atas, key yang digunakan untuk mengirim dan mengambil nilai data adalah sama,
yaitu EXTRA_NAME (yang bernilai “extra_name”). Nilai dari data yang dikirimkan melalui Intent
disimpan ke dalam variabel nama bertipe data string.

Fungsi dari EXTRA_NAME sendiri yaitu sebagai Key,untuk mengirim data dengan intent, kita perlu
mengirimnya dalam format putExtra(Key,Value). Dengan Key bertindak sebagai kunci yang dipakai
 untuk mengambil data di activity tujuannya dan value adalah data yang akan dikirimkan.
 */
        val usia = intent.getIntExtra(EXTRA_AGE, 0)
    /*
        Nilai dari variabel usia yang bertipe data integer berasal dari
        getIntent().getIntExtra(Key, nilai default). Key yang digunakan untuk mengirimkan dan
        mengambil data adalah EXTRA_AGE (yang bernilai “extra_age”). Nilai default di sini
        merupakan nilai yang akan digunakan jika ternyata datanya kosong. Data kosong atau nilainya
        null bisa terjadi ketika datanya memang tidak ada, atau key-nya tidak sama.
     */

        val teks = "Nama: $nama, Anda Usia: $usia"
        tvDataDiterima.text = teks
    }
}