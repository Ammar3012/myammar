package com.myammar.android
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemember = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemember = sharedPreferences.getBoolean("CHECKBOX", false)

        if (isRemember) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        btLogin.setOnClickListener {
            val user: String = etUser.text.toString()
            val pass : String = etPass.text.toString()
            val checked : Boolean = etBox.isChecked

            val editor:SharedPreferences.Editor= sharedPreferences.edit()
            editor.putString("USER", user)
            editor.putString("PASSWORD", pass)
            editor.putBoolean("CHECKBOX", checked)

            editor.apply()
            onButtonClick()

        }

    }


    private fun onButtonClick(){
       if (etUser.text.isNotBlank() && etPass.text.isNotBlank()) {
           Toast.makeText(this, "Information Saved!", Toast.LENGTH_LONG).show()
           navigateToHomeActivity()
       } else {
           Toast.makeText(this, "Please Fill in your Username and Password", Toast.LENGTH_LONG).show()
       }
    }

    private fun navigateToHomeActivity(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()

    }
}