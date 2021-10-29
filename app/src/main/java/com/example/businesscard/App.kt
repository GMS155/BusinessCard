package com.example.businesscard

import android.app.Application
import com.example.businesscard.data.AppDataBase
import com.example.businesscard.data.BusinessCardRepository

class App : Application(){
    val dataBase by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(dataBase.businessDao()) }
}