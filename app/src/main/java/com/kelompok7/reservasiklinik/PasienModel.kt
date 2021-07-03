package com.kelompok7.reservasiklinik

import java.text.DateFormat
import java.util.*

data class PasienModel(
    val tanggal: String = DateFormat.getInstance().format(Date()),
    val name: String = "",
    val usia: String = "",
    val jenisKelamin: String = "",
    val waktuPraktek: String = ""
)
