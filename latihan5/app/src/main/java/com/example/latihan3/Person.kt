package com.example.latihan3

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person (
    val nama: String?,
    val umur: Int?,
    val email: String?,
    val kota: String?
):Parcelable
// Dalam kode di atas, kita menciptakan sebuah objek Person bernama person yang mana kelas tersebut adalah Parcelable.

/*
Anotasi @Parcelize yang terletak di atas nama kelas digunakan untuk memberi tanda bahwa kelas
tersebut dipilih untuk menjadi parcelable. @Parcelize juga otomatis men-generate semua kode yang
digunakan untuk implemetasi parcelize sebelumnya.
 */