package com.jsbl.genix.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.jsbl.genix.model.DogBreed
import com.jsbl.genix.model.DogDatabase
import kotlinx.coroutines.launch

/**
 * Created by Muhammad Ali on 05-May-20.
 * Email muhammad.ali9385@gmail.com
 */
class DetailViewModel(application: Application) : BaseViewModel(application) {


    val dogObj = MutableLiveData<DogBreed>()
    private var uuid: String? = null

    fun setDetails(uuid: String) {
        this.uuid = uuid
        fetchFromDatabase()
    }

    fun setDogDetails(dogBreed: DogBreed) {
        dogObj.value = dogBreed
    }

    private fun fetchFromDatabase() {
        val dao = DogDatabase(getApplication()).dogDao()
        launch {
//            val dao = DogDatabase(getApplication()).dogDao()
            var dogb = dao.getDog(uuid!!)
            dogb.let {
                setDogDetails(it)
            }
        }
    }
}