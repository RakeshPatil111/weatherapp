package com.example.weatherapp.repository

import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.repository.db.WeatherDAO
import com.example.weatherapp.repository.service.WeatherAPI
import com.example.weatherapp.util.Constant
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: WeatherAPI,
    private val dao: WeatherDAO
) {

    suspend fun getWeather(cityName: String) =
        apiService.getWeather(cityName, Constant.API_ID)

    suspend fun upsertWeather(weather: WeatherModel) = dao.upsertWeather(weather)

    fun getAllLocalWeather() = dao.getAllWeathersFromLocal()

    fun getCityByName(cityName: String) = dao.getCityByName(cityName)
}