package com.myammar.android
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.default_toolbar.*

class HomeActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupTool()
        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val name = preferences.getString("USER", "")
        tvUs.text = name
        val pass = preferences.getString("PASSWORD", "")
        tvPas.text = pass

        btLogout.setOnClickListener {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun setupTool() {
        ivBack.setOnClickListener {
            this.finish()
        }


    }
}



