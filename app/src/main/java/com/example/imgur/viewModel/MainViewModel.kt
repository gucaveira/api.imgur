package com.example.imgur.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imgur.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val listImageLiveData = MutableLiveData<List<String>>()

    fun fetchImage(fetchImage: String) {
        viewModelScope.launch {
            repository.fetchImage(fetchImage).fold(onSuccess = { data ->

                val linkImage = mutableListOf<String>()

                data.data?.forEach { dataImage ->
                    dataImage.images?.map {
                        linkImage.add(it.link)
                    }
                }

                listImageLiveData.value = linkImage

            }, onFailure = {
                it.message
            })
        }
    }
}