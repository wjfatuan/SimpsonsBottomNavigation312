package co.edu.uan.android.simpsonsbottomnavigation312.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.uan.android.simpsonsbottomnavigation312.databinding.FragmentHomeBinding
import com.google.gson.JsonArray
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 * Esta pantalla permite ver informacion general sobre
 * la serie de TV "Los Simpsons": logo e historia
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.viewmodel = homeViewModel

        refreshData(homeViewModel)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun refreshData(model: HomeViewModel) {
        Picasso.get()
            .load(model.logo)
            .into(binding.imageView)
//        binding.simpsonsHistory.text = model.history
    }

    fun moveThis() {
        Ion.with(this)
            .load("https://api.sampleapis.com/simpsons/characters")
            .asJsonArray()
            .setCallback(object : FutureCallback<JsonArray> {
                override fun onCompleted(e: Exception?, result: JsonArray?) {
                    Log.d("IONLOAD",result?.get(0).toString())
                }
            })
    }
}