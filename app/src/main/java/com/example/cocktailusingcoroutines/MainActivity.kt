package com.example.cocktailusingcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var mainAdapter: MainAdapter?=null
    private var mainViewModel: MainViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }
    private fun initViewModel(){
       val rv= findViewById<RecyclerView>(R.id.rvMain)

        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mainViewModel = androidx.lifecycle.ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel?.getRecyclerListObserver()?.observe(this, Observer<RecyclerListModel>{
            Log.i("Msg",it.toString())
          if(it!=null){
              mainAdapter?.setUpdateData(it.drinks as ArrayList<Drink>)
              Log.i("Drinks",it.drinks.toString())
              rv.adapter=MainAdapter(this,it.drinks)


          }
            else{
                Toast.makeText(this,"Error in getting data", Toast.LENGTH_SHORT)
            }
        })
        mainViewModel!!.makeApiCall()
    }
}