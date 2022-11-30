package com.example.dndmonstersbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dndmonstersbook.adapter.MonstersAdapter
import com.example.dndmonstersbook.api.ApiConstants
import com.example.dndmonstersbook.api.ApiInterface
import com.example.dndmonstersbook.api.ServiceGenerator
import com.example.dndmonstersbook.model.MonstersModel
import com.example.dndmonstersbook.model.MonstersResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        monsters_recycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            getMonstersData { monsters : ArrayList<MonstersModel> ->
                monsters_recycler.adapter = MonstersAdapter(monsters)
            }
        }

        exit_icon.setOnClickListener(this)
    }

    private fun getMonstersData(callback: (ArrayList<MonstersModel>) -> Unit){
        val retrofitClient = ServiceGenerator.getRetrofitInstance(ApiConstants.BASE_URL)
        val endpoint = retrofitClient.create(ApiInterface::class.java)

        endpoint.getMonsters().enqueue(object : Callback<MonstersResponse> {

            override fun onFailure(call: Call<MonstersResponse>, t: Throwable) {
                Log.i("MainActivity", t.message ?: "Failure...")
            }

            override fun onResponse(call: Call<MonstersResponse>, response: Response<MonstersResponse>) {
                Log.i("MainActivity", response.toString())
                if(!response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                    return
                }
                return callback(response.body()!!.monsters as ArrayList<MonstersModel>)
            }
        })
    }

    override fun onClick(p0: View?) {
        finish()
    }
}