package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        /*
        Baris di atas menjelaskan bahwa bila fixed size bernilai true, RecyclerView dapat melakukan
        optimasi ukuran lebar dan tinggi secara otomatis. Nilai lebar dan tinggi RecyclerView
        menjadi konstan.
         */

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    /*
    Kode di atas digunakan untuk menampilkan menu pada Activity tertentu. Layout menu diambil dari option_menu.xml yang terdapat di folder menu.
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list ->{
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid ->{
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
            /*
            Paramater pertama merupakan context dan parameter kedua adalah jumlah kolom yang ingin
            dibuat. Anda juga bisa mengatur tampilan RecyclerView ketika landscape dan portrait.
             */

        }

        return super.onOptionsItemSelected(item)
        /*
        kita tinggal memasang event listener untuk dijalankan ketika item tersebut dipilih.
        Listener click pada menu action bar dapat memanfaatkan onOptionsItemSelected()

        Dengan melakukan percabangan menggunakan switch kita dapat memberikan listener pada setiap item. Seperti contoh di atas, ketika id-nya adalah R.id.list maka yang terjadi adalah kita mengatur layout manager menggunakan LinearLayoutManager. Ketika R.id.grid diklik, kita ganti menjadi GridLayoutManager.
         */
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()

        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object: ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero){
                showSelectedHero(data)
            }
        })
        /*
         data dapat dikonsumsi dari Activity dengan memanggil fungsi setOnItemClickCallback
         */

    }

    private fun showSelectedHero(hero: Hero){
        Toast.makeText(this, "Kamu memilih "+hero.name, Toast.LENGTH_SHORT).show()
    }


}