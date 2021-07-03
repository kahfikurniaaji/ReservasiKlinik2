package com.kelompok7.reservasiklinik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kelompok7.reservasiklinik.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    val PREFS_NAME = "ReservasiKlinik"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"
    val KEY_CHECKED = "key.checked"

    private lateinit var binding: ActivityLoginBinding

    private lateinit var sharedPref: SharedPreferences

    private var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        isRemembered = sharedPref.getBoolean(KEY_CHECKED, false)

        if (isRemembered) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun saveEmail(email: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    private fun savePassword(password: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
    }

    private fun saveChecked(checked: Boolean) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_CHECKED, checked)
        editor.apply()
    }

    private fun login() {
        val email = binding.etLoginEmail.text.toString()
        val password = binding.etLoginPassword.text.toString()
        val checked = binding.checkBox.isChecked
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(
                applicationContext,
                "Mohon Isi Kolom Email dan Password",
                Toast.LENGTH_LONG
            ).show()
        } else {
            saveEmail(email)
            savePassword(password)
            saveChecked(checked)
            Toast.makeText(
                applicationContext,
                "Berhasil Login",
                Toast.LENGTH_LONG
            ).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}