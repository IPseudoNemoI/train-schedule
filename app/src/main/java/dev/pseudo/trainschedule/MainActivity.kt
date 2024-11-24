package dev.pseudo.trainschedule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.pseudo.trainschedule.database.MainDb
import dev.pseudo.trainschedule.database.TrainItem
import dev.pseudo.trainschedule.databinding.ActivityMainBinding
import dev.pseudo.trainschedule.search_train.SearchTrainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GoToSearchTrainActivity()
        setupFocusListeners()
//        DatabaseCleaner()
//        DatabaseInsert()
    }

    fun GoToSearchTrainActivity() {
        binding.bSearch.setOnClickListener {
            if (binding.etFrom.text.toString() == "Новосибирск" && binding.etWhere.text.toString() == "Москва") {
                startActivity(Intent(this@MainActivity, SearchTrainActivity::class.java))
            } else {
                binding.tvError.text = "Маршрут не найден"
            }
        }
    }

    fun setupFocusListeners() {
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

//    fun DatabaseCleaner() {
//        val db = MainDb.getDb(this)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            db.clearAllTables()
//        }
//    }
//
//    fun DatabaseInsert() {
//        val db = MainDb.getDb(this)
//        val dao = db.getDao()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            dao.insertItem(
//                TrainItem(
//                    id = null,
//                    nameFrom = "Новосибирск",
//                    nameWhere = "Москва",
//                    price = 10000,
//                    timeStart = "10:00",
//                    timeFinish = "18:00"
//                )
//            )
//
//            dao.insertItem(
//                TrainItem(
//                    id = null,
//                    nameFrom = "Москва",
//                    nameWhere = "Новосибирск",
//                    price = 15000,
//                    timeStart = "11:00",
//                    timeFinish = "15:00"
//                )
//            )
//
//            dao.insertItem(
//                TrainItem(
//                    id = null,
//                    nameFrom = "Новосибирск",
//                    nameWhere = "Тюмень",
//                    price = 999,
//                    timeStart = "19:00",
//                    timeFinish = "22:00"
//                )
//            )
//        }
//    }
}