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
                    from = "Москва",
                    to = "Мурманск",
                    departureTime = "00:41",
                    duration = "8 ч 32 мин",
                    arrivalTime = "09:13",
                    station = "Ладожский вокзал",
                    prices = "Купе: 7188₽, СВ: 16755₽"
                ),
                TrainItem(
                    from = "Новосибирск",
                    to = "Мурманск",
                    departureTime = "00:43",
                    duration = "8 ч 53 мин",
                    arrivalTime = "09:36",
                    station = "Московский вокзал",
                    prices = "Купе: 5999₽, СВ: 18000₽"
                ),
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
                    from = "Москва",
                    to = "Мурманск",
                    departureTime = "02:05",
                    duration = "8 ч 42 мин",
                    arrivalTime = "10:47",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 1910₽, Купе: 3609₽"
                ),
                TrainItem(
                    from = "Москва",
                    to = "Мурманск",
                    departureTime = "02:13",
                    duration = "11 ч 5 мин",
                    arrivalTime = "13:18",
                    station = "Московский вокзал",
                    prices = "Плацкарт: 1910₽, Купе: 3332₽"
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