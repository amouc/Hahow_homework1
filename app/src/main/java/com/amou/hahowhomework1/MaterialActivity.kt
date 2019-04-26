package com.amou.hahowhomework1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.replay_game))
                .setMessage((getString(R.string.are_you_sure)))
                .setPositiveButton(getString(R.string.ok),{dialog, which ->
                    secretNumber.reset()
                    text_secret.setText(secretNumber.secret.toString())
                    text_count.setText(secretNumber.count.toString())

                })
                .setNeutralButton(getString(R.string.cancel),null)
                .show()
        }
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
        }else if (diff == 0 && secretNumber.count<3){
            message = getString(R.string.excellent_the_number_is)+secretNumber.secret
        }
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
    }

}
