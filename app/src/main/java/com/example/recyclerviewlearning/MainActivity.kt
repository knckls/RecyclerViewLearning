package com.example.recyclerviewlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = FlagAdapter()
    private val imageIdList = listOf(
        R.drawable.australia,
        R.drawable.azerbaijan,
        R.drawable.brazil,
        R.drawable.georgia,
        R.drawable.india,
        R.drawable.kazakhstan,
        R.drawable.netherlands,
        R.drawable.russia,
        R.drawable.singapore,
        R.drawable.southkorea,
        R.drawable.uae,
        R.drawable.usa
    )

    private var i = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        init()

    }

    private fun init() = with(binding) {
        val countryArray = resources.getStringArray(R.array.countries)
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (i > 11) i = 0
                val flag = Flag(imageIdList[i], "${countryArray[i]}")
                adapter.addFlag(flag)
                i++
            }
    }
}