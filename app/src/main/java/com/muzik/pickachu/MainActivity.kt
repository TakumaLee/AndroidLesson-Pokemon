package com.muzik.pickachu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fabPickachu.setOnClickListener { view ->
            val attack = 300
            var hp = textKamexHP.text.toString().toInt()
            hp -= attack
            textKamexHP.text = "$hp"
            progressBarKamex.progress = hp
        }

        fabKamex.setOnClickListener { view ->
            val attack = 300
            var hp = textPickachuHP.text.toString().toInt()
            hp -= attack
            textPickachuHP.text = "$hp"
            progressBarPickachu.progress = hp
        }
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
