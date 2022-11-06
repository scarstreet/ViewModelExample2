package com.example.viewmodelexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexample2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        binding.addBtn.setOnClickListener{
            viewModel.add()
        }
        binding.resetBtn.setOnClickListener{
            viewModel.reset()
        }
        viewModel.counter.observe(this) {
            count -> binding.counterText.text = count.toString()
        }

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}