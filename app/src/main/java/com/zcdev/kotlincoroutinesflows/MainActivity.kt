package com.zcdev.kotlincoroutinesflows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        runBlocking {
            //producer
            var flow1 = flow<Int> {
                for (i in 1..10) {
                    emit(i)
                    Log.d("data", i.toString())
                    delay(1000)
                }

            }.filter { i: Int -> i < 5 }//intermdiate
                .buffer().collect {    // buffer for run producer and collcter on 2 coroutines
                    delay(2000)
                    Log.d("res", it.toString())
                }    // collecter


        }
        run2Flow()
    }

    private fun run2Flow() {

        runBlocking {
            //producer
            var flow1 = flow<Int> {
                for (i in 1..10) {
                    emit(i)
                    //     Log.d("data", i.toString())
                    delay(1000)
                }

            }


            var flow2 = flow<String> {
                val listColor = listOf<String>("red", "black", "green")
                for (i in listColor) {
                    emit(i)
                    //Log.d("data", i)
                }

            }
            flow1.zip(flow2) { a, b ->
                "$a:$b"

            }.collect {
                Log.d("res", it)
            }

        }
    }
}