package com.example.imgur

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imgur.adapter.AdapterImage
import com.example.imgur.databinding.ActivityMainBinding
import com.example.imgur.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchImage("cats")

        viewModel.listImageLiveData.observe(this) {
            binding.imageList.adapter = AdapterImage(it)
        }
    }
}