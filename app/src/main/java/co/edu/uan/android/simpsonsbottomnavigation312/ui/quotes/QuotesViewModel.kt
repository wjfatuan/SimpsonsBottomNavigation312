package co.edu.uan.android.simpsonsbottomnavigation312.ui.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.uan.android.simpsonsbottomnavigation312.services.SimpsonsQuotesApi
import kotlinx.coroutines.launch

class QuotesViewModel : ViewModel() {

    val character: MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "Moe"
    }
    val quote: MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "Usted no sabe quien soy yo"
    }
    val image: MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "https://google"
    }

    fun refreshQuote() {
        viewModelScope.launch {
            val api = SimpsonsQuotesApi.getInstance()
            val data = api.quotes(1)
            character.value = data[0].character
            quote.value = data[0].quote
            image.value = data[0].image
        }
    }

}