package dev.pseudo.trainschedule.search_train

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.pseudo.trainschedule.adapter.TrainAdapter
import dev.pseudo.trainschedule.database.Dao
import dev.pseudo.trainschedule.database.MainDb
import dev.pseudo.trainschedule.database.TrainItem
import dev.pseudo.trainschedule.databinding.FragmentSearchTrainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchTrainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var trainAdapter: TrainAdapter
    private lateinit var trainDao: Dao
    private lateinit var binding: FragmentSearchTrainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchTrainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ibBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        val db = MainDb.getDb(requireContext())
        trainDao = db.getDao()

        CoroutineScope(Dispatchers.IO).launch {
            trainDao.clearAll()

            val initialData = listOf(
                TrainItem(
                    from = "Новосибирск",
                    to = "Москва",
                    departureTime = "01:00",
                    duration = "10 ч 22 мин",
                    arrivalTime = "11:22",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 1910₽, Купе: 3945₽"
                ),
                TrainItem(
                    from = "Новосибирск",
                    to = "Москва",
                    departureTime = "04:00",
                    duration = "10 ч 22 мин",
                    arrivalTime = "15:22",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 1710₽, Купе: 3445₽"
                ),
                TrainItem(
                    from = "Новосибирск",
                    to = "Москва",
                    departureTime = "09:00",
                    duration = "10 ч 22 мин",
                    arrivalTime = "19:22",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 2050₽, Купе: 4945₽"
                ),
                TrainItem(
                    from = "Москва",
                    to = "Мурманск",
                    departureTime = "02:13",
                    duration = "11 ч 5 мин",
                    arrivalTime = "13:18",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 1910₽, Купе: 3332₽"
                ),
                TrainItem(
                    from = "Москва",
                    to = "Санкт-Петербург",
                    departureTime = "08:00",
                    duration = "4 ч 30 мин",
                    arrivalTime = "12:30",
                    station = "Ладожский вокзал",
                    prices = "Плацкарт: 1120₽, Купе: 2500₽"
                ),
                TrainItem(
                    from = "Санкт-Петербург",
                    to = "Москва",
                    departureTime = "10:00",
                    duration = "4 ч 30 мин",
                    arrivalTime = "14:30",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 1150₽, Купе: 2600₽"
                ),
                TrainItem(
                    from = "Краснодар",
                    to = "Ростов-на-Дону",
                    departureTime = "06:30",
                    duration = "1 ч 50 мин",
                    arrivalTime = "08:20",
                    station = "Краснодар-1",
                    prices = "Плацкарт: 700₽, Купе: 1500₽"
                ),
                TrainItem(
                    from = "Ростов-на-Дону",
                    to = "Краснодар",
                    departureTime = "07:15",
                    duration = "1 ч 50 мин",
                    arrivalTime = "09:05",
                    station = "Ростов-Главный",
                    prices = "Плацкарт: 700₽, Купе: 1550₽"
                ),
                TrainItem(
                    from = "Сочи",
                    to = "Москва",
                    departureTime = "12:00",
                    duration = "24 ч 15 мин",
                    arrivalTime = "12:15",
                    station = "Сочи",
                    prices = "Плацкарт: 3200₽, Купе: 7000₽"
                ),
                TrainItem(
                    from = "Москва",
                    to = "Сочи",
                    departureTime = "15:00",
                    duration = "24 ч 30 мин",
                    arrivalTime = "15:30",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 3500₽, Купе: 7500₽"
                ),
                TrainItem(
                    from = "Москва",
                    to = "Сочи",
                    departureTime = "15:00",
                    duration = "24 ч 30 мин",
                    arrivalTime = "15:30",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 3100₽, Купе: 7900₽"
                ),
                TrainItem(
                    from = "Москва",
                    to = "Сочи",
                    departureTime = "15:00",
                    duration = "24 ч 30 мин",
                    arrivalTime = "15:30",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 3900₽, Купе: 6100₽"
                ),
                TrainItem(
                    from = "Казань",
                    to = "Нижний Новгород",
                    departureTime = "09:00",
                    duration = "3 ч 15 мин",
                    arrivalTime = "12:15",
                    station = "Казань-1",
                    prices = "Плацкарт: 900₽, Купе: 2000₽"
                ),
                TrainItem(
                    from = "Нижний Новгород",
                    to = "Казань",
                    departureTime = "10:30",
                    duration = "3 ч 15 мин",
                    arrivalTime = "13:45",
                    station = "Нижний Новгород",
                    prices = "Плацкарт: 950₽, Купе: 2100₽"
                ),
                TrainItem(
                    from = "Екатеринбург",
                    to = "Челябинск",
                    departureTime = "07:00",
                    duration = "2 ч 30 мин",
                    arrivalTime = "09:30",
                    station = "Екатеринбург-1",
                    prices = "Плацкарт: 650₽, Купе: 1500₽"
                ),
                TrainItem(
                    from = "Челябинск",
                    to = "Екатеринбург",
                    departureTime = "08:15",
                    duration = "2 ч 30 мин",
                    arrivalTime = "10:45",
                    station = "Челябинск",
                    prices = "Плацкарт: 670₽, Купе: 1550₽"
                )
            )
            trainDao.insertTrains(initialData)
            withContext(Dispatchers.Main) {
                val fromStation = arguments?.getString("fromStation") ?: ""
                val toStation = arguments?.getString("toStation") ?: ""

                trainDao.searchTrains(fromStation, toStation)
                    .observe(viewLifecycleOwner) { trains ->
                        trainAdapter = TrainAdapter(trains)
                        recyclerView.adapter = trainAdapter
                    }
            }
        }

        recyclerView = binding.rv
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchTrainFragment()
    }
}