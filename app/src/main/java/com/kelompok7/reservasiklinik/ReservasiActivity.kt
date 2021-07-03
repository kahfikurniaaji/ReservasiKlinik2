package com.kelompok7.reservasiklinik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.kelompok7.reservasiklinik.databinding.ActivityReservasiBinding

class ReservasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReservasiBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservasiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        database = Firebase.database
        reference = database.getReference("Pasien")

        binding.btnReservasi.setOnClickListener {
            sendData()
        }
    }

    private fun sendData() {
        val nama = binding.etReservasiNamaLengkap.text.toString()
        val usia = binding.etReservasiUsia.text.toString()
        var jenisKelamin = ""
        var id = binding.rgJenisKelamin.checkedRadioButtonId

        when (id) {
            binding.radioMale.id -> {
                jenisKelamin = "Laki-laki"
            }
            binding.radioFemale.id -> {
                jenisKelamin = "Perempuan"
            }
        }

        var waktu = ""
        id = binding.rgWaktu.checkedRadioButtonId
        when (id) {
            binding.radioPagi.id -> {
                waktu = "Pagi"
            }
            binding.radioSore.id -> {
                waktu = "Sore"
            }
        }

        val model =
            PasienModel(name = nama, usia = usia, jenisKelamin = jenisKelamin, waktuPraktek = waktu)
        val pasienId = reference.push().key
        reference.child(pasienId!!).setValue(model)
        Toast.makeText(applicationContext, "Sukses", Toast.LENGTH_LONG).show()
        binding.etReservasiNamaLengkap.setText("")
        binding.etReservasiUsia.setText("")
    }
}