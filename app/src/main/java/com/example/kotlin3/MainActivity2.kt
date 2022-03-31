package com.example.kotlin3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Part.TEXT
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin3.adapter.GoatAdapter
import com.example.kotlin3.adapter.SecondAdapter
import com.example.kotlin3.databinding.ActivityMain2Binding
import com.example.kotlin3.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: SecondAdapter
    var list = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        registerForActivity()
        creatList()
        initRV()
    }

    private fun initRV() {
        adapter = SecondAdapter()
        adapter.setList(list)
        binding.rvGoat.adapter = adapter
    }

    private fun creatList() {
        intent.getIntegerArrayListExtra(TEXT)?.let {
            list.addAll(it)
        }
    }

    private fun registerForActivity() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == RESULT_OK){
                result.data?.getIntegerArrayListExtra(TEXT)?.let {
                    list.addAll(it)
                }
            }
        }
    }
}