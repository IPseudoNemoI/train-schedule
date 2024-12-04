package dev.pseudo.trainschedule

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.pseudo.trainschedule.databinding.ActivityMainBinding
import dev.pseudo.trainschedule.search_train.SearchTrainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GoToSearchTrainActivity()
        setupFocusListeners()
    }

    private fun GoToSearchTrainActivity() {
        binding.bSearch.setOnClickListener {
            val from = binding.etFrom.text.toString()
            val to = binding.etWhere.text.toString()

            if (from.isNotEmpty() && to.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SearchTrainActivity::class.java).apply {
                    putExtra("fromStation", from)
                    putExtra("toStation", to)
                }
                startActivity(intent)
            } else {
                binding.tvError.text = "Введите станции отправления и прибытия"
            }
        }
    }


    private fun setupFocusListeners() {
        binding.etFrom.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.tvError.text = ""
                binding.etFrom.hint = ""
            } else {
                binding.etFrom.hint = "Откуда"

            }

            binding.etWhere.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    binding.tvError.text = ""
                    binding.etWhere.hint = ""
                } else {
                    binding.etWhere.hint = "Куда"
                }
            }
        }
    }
}