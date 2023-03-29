package com.mg.finaldiplomado.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.finaldiplomado.model.enties.Product
import com.mg.finaldiplomado.model.network.ApiDbClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel(){
    var productList: ArrayList<Product> = arrayListOf()
    var list = MutableLiveData<ArrayList<Product>>()

    init {
        getProductsList()
    }

    private fun getProductsList() {
        CoroutineScope(Dispatchers.IO).launch{
            val call = ApiDbClient.service.getProducts("products")
            val products = call.execute().body()
            productList = ((products?.product ?: emptyList()) as ArrayList<Product>)
            list.postValue(productList)

        }
    }
}