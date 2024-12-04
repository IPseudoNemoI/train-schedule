package dev.pseudo.trainschedule.search_train

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.pseudo.trainschedule.R
import dev.pseudo.trainschedule.databinding.ActivitySearchTrainBinding

class SearchTrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchTrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySearchTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fromStation = intent.getStringExtra("fromStation") ?: ""
        val toStation = intent.getStringExtra("toStation") ?: ""

        val fragment = SearchTrainFragment().apply {
            arguments = Bundle().apply {
                putString("fromStation", fromStation)
                putString("toStation", toStation)
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, fragment)
            .commit()
    }
}