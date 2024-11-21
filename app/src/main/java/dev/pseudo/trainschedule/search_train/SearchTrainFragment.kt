package dev.pseudo.trainschedule.search_train

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.pseudo.trainschedule.R
import dev.pseudo.trainschedule.databinding.FragmentSearchTrainBinding


class SearchTrainFragment : Fragment() {

    lateinit var binding: FragmentSearchTrainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchTrainBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchTrainFragment()
    }
}