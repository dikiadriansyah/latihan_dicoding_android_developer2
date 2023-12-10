package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
      this.onItemClickCallback = onItemClickCallback
    }

    /*
    menambahkan interface supaya ketika memanggil fungsi setOnItemClickCallback, terdapat data yang dikembalikan.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    /*
    * Fungsi onCreateViewHolder() digunakan untuk membuat ViewHolder baru yang berisi layout item yang digunakan, dalam hal ini yaitu R.layout.item_row_hero
    * */

    override fun getItemCount(): Int =  listHero.size
    /*
    Fungsi getItemCount() digunakan untuk menetapkan ukuran dari list data yang ingin ditampilkan.
     Karena kita ingin menampilkan semua data, maka kita menggunakan listHero.size untuk mengetahui jumlah data pada list.
     */

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "Kamu memilih "+ listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }

    }
    /*
    Fungsi onBindViewHolder() digunakan untuk menetapkan data yang ada ke dalam ViewHolder sesuai dengan posisinya dengan menggunakan listHero[position].
     */

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder (itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
    /*
    Kelas ListViewHolder digunakan sebagai ViewHolder dalam RecyclerView. ViewHolder adalah wrapper seperti View yang berisi layout untuk setiap item dalam daftar RecyclerView.
     */

    interface OnItemClickCallback{
        fun onItemClicked(data: Hero)
    }

}