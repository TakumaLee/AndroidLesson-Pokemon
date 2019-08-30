package com.muzik.pickachu

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fabPickachu.setOnClickListener { view ->
            // big data
            Thread {
                specialAttack()
            }.start()

//            attack(textKamexHP, progressBarKamex)
        }

        fabKamex.setOnClickListener { view ->
            attack(300, textPickachuHP, progressBarPickachu)
        }
    }

    private fun specialAttack() {
        var thunderStorage = 0
        for (i in 0 .. 9) {
            thunderStorage += 50
            Log.v("Special Attack", "thunder: $thunderStorage i: $i")
            Thread.sleep(500)
        }
        // attack = 500
        runOnUiThread {
            attack(thunderStorage, textKamexHP, progressBarKamex)
        }

    }

    private fun attack(attack: Int, textHP: TextView, progressBarHP: ProgressBar) {
        var hp = textHP.text.toString().toInt()
        if (attack > hp) {
            hp = 0
        } else {
            hp -= attack
        }
        textHP.text = "$hp"
        progressBarHP.progress = hp
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
