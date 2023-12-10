package com.example.latihan3
// Latihan Explicit Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahAktifiti: Button = findViewById(R.id.btn_pindah1)
    btnPindahAktifiti.setOnClickListener(this)

        val btnPindahAktifitiData: Button = findViewById(R.id.btn_pindah_activity_data)
        btnPindahAktifitiData.setOnClickListener(this)

        val btnPindahDenganObjek: Button = findViewById(R.id.btn_pindah_activity_objek)
        btnPindahDenganObjek.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
   when(v?.id){
       R.id.btn_pindah1->{
val pindahIntent = Intent(this@MainActivity, PindahActivity::class.java)
/*
* Kita membuat suatu objek intent dengan cara seperti di atas dengan memberikan context
* (this@MainActivity) dan kelas activity tujuan (MoveActivity::class.java) pada
* konstruktor kelas intent.
*
* Untuk context dapat menggunakan this yang menandakan objek kelas saat ini, sedangkan kelas tujuan
* selalu diakhiri dengan menggunakan class.
*
* Context adalah sebuah kelas yang digunakan untuk mengakses resource dari activity tersebut. Anda
* akan sering membutuhkan context pada latihan-latihan selanjutnya, seperti saat mengambil data
* dari resource, mengakses SystemService, mendapatkan ApplicationInfo, dan lain sebagainya.
* */
           startActivity(pindahIntent)
/*
* Metode startActivity(moveIntent) akan menjalankan activity baru tanpa membawa data. Objek intent
* yang diinputkan adalah objek moveIntent yang ketika kode ini dijalankan maka akan
* membuka MoveActivity.
* */
       }
//-----------------------
       R.id.btn_pindah_activity_data->{
           val pindahDataIntent = Intent(this@MainActivity, PindahDataActivity::class.java)

           pindahDataIntent.putExtra(PindahDataActivity.EXTRA_NAME, "Ir.Dhiki")
           pindahDataIntent.putExtra(PindahDataActivity.EXTRA_AGE,24)
 /*
 *  metode putExtra() untuk mengirimkan data bersamaan dengan obyek Intent. Namun, metode putExtra()
 *  itu sendiri merupakan metode yang menampung pasangan key-value dan memiliki beberapa pilihan
 * tipe input seperti berikut.
 *
 * Name PindahDataActivity.EXTRA_NAME di mana EXTRA_NAME adalah variabel static bertipe data String dan bernilai extra_name pada PindahDataActivity
 * Value Ir.Dhiki dengan tipe data string
 * */

//           PindahDataActivity.EXTRA_NAME dimana EXTRA_NAME adalah variabel static bertipe data String dan bernilai extra_name pada PindahDataActivity
//      value Ir.Dhiki dengan tipe data string
           
           startActivity(pindahDataIntent)
       }
       //-----------------------
       R.id.btn_pindah_activity_objek -> {
           val person = Person("Dina Salsabila", 32,"dina@gmail.com","Bandung")

           val pindahDenganObjekIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
           pindahDenganObjekIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
           startActivity(pindahDenganObjekIntent)

       }
   }
    }
}