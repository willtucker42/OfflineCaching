package com.codinginflow.simplecachingexample.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinginflow.simplecachingexample.api.RestaurantApi
import com.codinginflow.simplecachingexample.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    api: RestaurantApi
): ViewModel(){
    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData
    init {
        // init block gets executed right when we open the first screen of the app (Restaurant activity which instantiates this class
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            delay(5000)
            restaurantsLiveData.value = restaurants
        }
    }
}