package com.mg.finaldiplomado.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.finaldiplomado.model.enties.Publication
import com.mg.finaldiplomado.model.network.ApiDbClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PublicationsViewModel : ViewModel() {
    var publicationList: ArrayList<Publication> = arrayListOf()
    var list = MutableLiveData<ArrayList<Publication>>()

    init {
        getPublicationsList()
    }

    private fun getPublicationsList() {
        CoroutineScope(Dispatchers.IO).launch{
            val call = ApiDbClient.service.getPublications("publications")
            val publication = call.execute().body()
            publicationList = ((publication?.publication ?: emptyList()) as ArrayList<Publication>)
            list.postValue(publicationList)

        }
    }
}