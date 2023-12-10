package com.example.latihan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
/*
* Kode dalam berkas Java / Kotlin di atas berarti sebuah class MainActivity inherit ke superclass
* bernama AppCompatActivity. AppCompatActivity merupakan kelas dasar yang mengatur
* fungsi dasar Activity supaya bisa tetap berjalan pada versi Android lama, seperti
* pengaturan tema dan app bar.
*
* OnClickListener adalah listener yang kita implementasikan untuk memantau kejadian klik pada
* komponen tombol (button).
* */

    /*
mengenalkan variabel yang akan digunakan untuk menampung View.
*/
    private lateinit var etLebar: EditText
    private lateinit var etTinggi: EditText
    private lateinit var etPanjang: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView
/*
* keyword lateinit untuk mendeklarasikan variabel tanpa memberikan nilai awal kepadanya. Ini
* memungkinkan Anda untuk menunda inisialisasi variabel hingga saat diperlukan. Hal ini biasa
* digunakan jika kita ingin membuat global variable yang tidak bersifat nullable.
* */

//    ------------
    companion object {
        private const val STATE_RESULT = "state_result"
    }
//    ----------------

    override fun onCreate(savedInstanceState: Bundle?) {
/*
* Metode onCreate() merupakan metode utama yang pertama kali dipanggil pada Activity
* Di sinilah kita dapat mengatur layout XML. Semua proses inisialisasi komponen yang digunakan akan
* dijalankan di sini. Pada metode ini kita menghubungkan semua variabel dengan komponen view
* dari XML agar dapat kita kelola interaksinya, seperti mengambil data, mengatur data, ataupun
* memantau aksi klik.
* */

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
* setContentView di atas adalah kelas MainActivity akan menampilkan tampilan yang berasal dari layout
* activity_main.xml. Biasanya sebuah Activity terhubung dengan sebuah XML juga.
* */

        etLebar = findViewById(R.id.et_lebar)
  /*
  * casting view diatas adalah variabel etLebar dengan tipe data EditText, akan dihubungkan dengan
  * komponen EditText ber-ID et_lebar di layout activity_main.xml melalui metode findViewById().
  * */
        etTinggi = findViewById(R.id.et_tinggi)
        etPanjang = findViewById(R.id.et_panjang)
        btnHitung = findViewById(R.id.btn_hitung)
        tvHasil = findViewById(R.id.tv_hasil)

        btnHitung.setOnClickListener(this)
    /*
    setOnClickListener diatas adalah untuk obyek btnCalculate sehingga sebuah aksi dapat dijalankan
    ketika obyek tersebut diklik. Keyword this merujuk pada obyek Activity saat ini yang telah
    mengimplementasikan listener OnClickListener sebelumnya.  Sehingga ketika btnCalculate diklik,
    maka fungsi onClick akan dipanggil dan melakukan proses yang ada di dalamnya.
     */

//        -------------
// melakukan pengecekan
        if(savedInstanceState != null){
            val hasil = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = hasil

        }
/*
* Pada onCreate inilah kita menggunakan nilai bundle yang telah kita simpan sebelumnya pada
* onSaveInstanceState. Nilai tersebut kita dapatkan dengan menggunakan Key yang sama dengan saat
* menyimpan, yaitu STATE_RESULT. Kemudian kita isikan kembali pada tvResult.
* */
//        -------------

    }

    //    ---------------------
// kode untuk pergantian orientasi pada peranti (potrait-landscape)
    override fun onSaveInstanceState(outState: Bundle){
//        onSaveInstanceState adalah class yang ada di superclass AppCompatActivity, Anda
//        bisa membuat fungsi secara otomatis dengan hanya mengetikkan huruf onSave
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }
    /*
    * Di dalam metode onSaveInstanceState,  hasil perhitungan yang ditampilkan pada tvResult dimasukkan
    * pada bundle kemudian disimpan isinya. Untuk menyimpan data disini menggunakan konsep Key-Value,
    * dengan STATE_RESULT sebagai key dan isi dari tvResult sebagai value. Fungsi onSaveInstanceState
    * akan dipanggil secara otomatis sebelum sebuah Activity hancur. Di sini kita perlu menambahkan
    * onSaveInstanceState karena ketika orientasi berubah, Activity tersebut akan di-destroy dan
    * memanggil fungsi onCreate lagi, sehingga kita perlu menyimpan nilai hasil perhitungan tersebut
    * supaya data tetap terjaga dan tidak hilang ketika orientasi berubah.
    * */
//    ---------------------

    override fun onClick(vi: View?) {

        if(vi?.id == R.id.btn_hitung){
            val panjangInput = etPanjang.text.toString().trim()
//        Sintaks .text.toString() di atas berfungsi untuk mengambil isi dari sebuah EditText
//        kemudian menyimpannya dalam sebuah variabel. Tambahan .trim() berfungsi untuk
//        menghiraukan spasi jika ada, sehingga nilai yang didapat hanya berupa angka.
            val lebarInput = etLebar.text.toString().trim()
            val tinggiInput = etTinggi.text.toString().trim()

            //    Validasi apakah inputan masih ada yang kosong
            var bidangKosong = false // memberikan nilai awal false
            if(panjangInput.isEmpty()){
                // mengecek apakah panjangInput bernilai false
                bidangKosong = true
                etPanjang.error = "Bidang ini tidak boleh kosong"
            }

            if(lebarInput.isEmpty()){
//             Sintaks .isEmpty() berfungsi untuk mengecek apakah inputan dari Editext itu masih
//             kosong. Jika iya, maka kita akan menampilkan pesan error dengan menggunakan
//             .setError("Field ini tidak boleh kosong") dan mengganti variabel Boolean isEmptyField
  //             menjadi true supaya bisa lanjut ke proses selanjutnya.

                bidangKosong = true
             etLebar.error = "Bidang ini tidak boleh kosong"
            }

            if(tinggiInput.isEmpty()){
                // mengecek apakah tinggiInput bernilai false

                bidangKosong = true
                etTinggi.error = "Bidang  tidak boleh kosong"
            }

//            menampilkan data ke TextView
            if(!bidangKosong){
//           Sintaks !isEmptyFields memiliki arti "jika semua inputan tidak kosong". Jika kondisi
//           tersebut terpenuhi, maka langkah selanjutnya yaitu melakukan proses perhitungan. Karena
//           yang didapat dari EditText berupa String maka Anda perlu mengkonversinya terlebih
//           dahulu dengan cara toDouble().
                val volume = panjangInput.toDouble() * lebarInput.toDouble() * tinggiInput.toDouble()
                tvHasil.text = volume.toString()
//            menampilkan hasil perhitungan pada TextView tvHasil dengan menggunakan .text. Di sini
//            dapat kita lihat bahwa kita perlu merubah datanya yang sebelumnya Double menjadi
//            String dengan menggunakan toString() karena untuk menampilkan data dengan .text harus
//            berupa String.
            }

        }
    }



}