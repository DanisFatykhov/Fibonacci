package com.nopro.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nopro.fibonacci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: NumberAdapter
    private lateinit var numbersItemList: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        numbersItemList = ArrayList()

        for (i in 1..15) {
            numbersItemList.add(i)
        }

        mAdapter = NumberAdapter(context = this, numbersItemList = numbersItemList)

        binding.rvNumbers.adapter = mAdapter
        binding.rvNumbers.layoutManager = GridLayoutManager(this, 2)
    }
}