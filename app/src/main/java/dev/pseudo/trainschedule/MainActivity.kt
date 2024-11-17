package dev.pseudo.trainschedule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.pseudo.trainschedule.databinding.ActivityMainBinding
import dev.pseudo.trainschedule.search_train.SearchTrainActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GoToSearchTrainActivity()
        setupFocusListeners()
    }

    fun GoToSearchTrainActivity() {
        binding.bSearch.setOnClickListener {
            if (binding.etFrom.text.toString() == "Новосибирск" && binding.etWhere.text.toString() == "Москва") {
                startActivity(Intent(this@MainActivity, SearchTrainActivity::class.java))
            } else {
                Log.d("damn", "Unluck")
                binding.tvError.text = "Маршрут не найден"
            }
        }
    }

    fun setupFocusListeners() {
        binding.etFrom.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus) {
                binding.tvError.text = ""
            }
        }

        binding.etWhere.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus) {
                binding.tvError.text = ""
            }
        }
    }
}