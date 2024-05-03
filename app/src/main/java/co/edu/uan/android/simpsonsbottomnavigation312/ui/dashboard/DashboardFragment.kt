package co.edu.uan.android.simpsonsbottomnavigation312.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.uan.android.simpsonsbottomnavigation312.databinding.FragmentDashboardBinding
import com.squareup.picasso.Picasso

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        dashboardViewModel.loadCats()
        dashboardViewModel.saveCats()
        dashboardViewModel.cats.observe(viewLifecycleOwner) {
            updateImages()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateImages() {
        binding.catsContainer.removeAllViews()
        for(cat in dashboardViewModel.cats.value!!) {
            val iv = ImageView(this.requireActivity())
            Picasso.get()
                .load(cat.url)
                .into(iv)
            binding.catsContainer.addView(iv)
        }
    }
}