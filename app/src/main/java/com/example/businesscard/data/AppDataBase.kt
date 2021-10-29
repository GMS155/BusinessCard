package com.example.businesscard.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import java.util.jar.Attributes.*

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun businessDao(): BusinessCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "businessCard_bd"
                ).build()
                INSTANCE = instance
                instance
            }

        }

    }

}