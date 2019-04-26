package com.amou.hahowhomework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_secret.setText(secretNumber.secret.toString())
        text_count.setText(secretNumber.count.toString())
    }

    fun check(view: View){
        val number = ed_number.text.toString().toInt()
        val diff = secretNumber.validate(number)
        text_count.setText(secretNumber.count.toString())
        var message = getString(R.string.yes_you_go_it)
        if(diff>0){
            message = getString(R.string.smaller)
        }else if(diff < 0){
            message = getString(R.string.bigger)
        }
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
    }
}
