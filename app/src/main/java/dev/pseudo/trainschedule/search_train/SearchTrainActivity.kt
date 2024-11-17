package dev.pseudo.trainschedule.search_train

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.pseudo.trainschedule.R
import dev.pseudo.trainschedule.databinding.ActivitySearchTrainBinding

class SearchTrainActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchTrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySearchTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}