package co.edu.uan.android.simpsonsbottomnavigation312.ui.quotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.uan.android.simpsonsbottomnavigation312.databinding.FragmentQuotesBinding
import com.squareup.picasso.Picasso

class QuotesFragment : Fragment() {

    private var _binding: FragmentQuotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quotesViewModel =
            ViewModelProvider(this).get(QuotesViewModel::class.java)

        _binding = FragmentQuotesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.viewmodel = quotesViewModel
        binding.lifecycleOwner = this
        quotesViewModel.refreshQuote()

        quotesViewModel.image.observe(viewLifecycleOwner) {
            refreshImage(quotesViewModel)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun refreshImage(vm: QuotesViewModel) {
        Log.d("SIMPSONSAPP", "Quote image value: ${vm.image.value}")
        Log.d("SIMPSONSAPP", "Quote image string: ${vm.image.toString()}")
        Picasso.get()
            .load(vm.image.value)
            .into(binding.imageCharacter)
    }
}