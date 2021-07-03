package com.kelompok7.reservasiklinik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kelompok7.reservasiklinik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val PREFS_NAME = "ReservasiKlinik"

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        binding.cvReservasi.setOnClickListener {
            startActivity(Intent(applicationContext, ReservasiActivity::class.java))
        }

        binding.cvRiwayatReservasi.setOnClickListener {
            startActivity(Intent(applicationContext, RiwayatReservasiActivity::class.java))
        }

        binding.cvJadwalDokter.setOnClickListener {

        }

        binding.cvLogout.setOnClickListener {
            onLogout()
        }
    }

    fun onLogout() {
        clearData()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun clearData() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }
}