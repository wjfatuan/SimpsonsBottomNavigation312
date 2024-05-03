package co.edu.uan.android.simpsonsbottomnavigation312.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.uan.android.simpsonsbottomnavigation312.database.Cat
import co.edu.uan.android.simpsonsbottomnavigation312.database.CatsDatabase
import co.edu.uan.android.simpsonsbottomnavigation312.services.CatsApi
import kotlinx.coroutines.launch

class DashboardViewModel(val ctx: Application) : AndroidViewModel(ctx) {

    val cats = MutableLiveData<List<CatImage>>().apply {
        value = arrayListOf()
    }

    fun saveCats() {
        val catsDb = CatsDatabase.getInstance(ctx)
        viewModelScope.launch {
            for (c in cats.value!!)
                catsDb.getCatsDao().create(Cat(c.id, c.url))
        }
    }

    fun loadCats() {
        val catsApi = CatsApi.getInstance()
        viewModelScope.launch {
            val c = catsApi.search(3)
            cats.value = c.asList()
        }
    }
}