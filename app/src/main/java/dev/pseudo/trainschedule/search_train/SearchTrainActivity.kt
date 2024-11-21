package dev.pseudo.trainschedule.search_train

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.pseudo.trainschedule.databinding.ActivitySearchTrainBinding

class SearchTrainActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchTrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySearchTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.placeHolder.id, SearchTrainFragment.newInstance())
            .commit()
    }
}