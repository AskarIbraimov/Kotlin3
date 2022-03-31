package com.example.kotlin3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Part.TEXT
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin3.adapter.GoatAdapter
import com.example.kotlin3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    var imageList = arrayListOf<Int>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: GoatAdapter
    var list = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        creatList()
        initRecycler()
        registerForActivity()
        onClickFab()
    }

    private fun onClickFab() {
        binding.fab.setOnClickListener {
            openActivity(imageList)
        }
    }

    private fun openActivity(imageList: ArrayList<Int>) {
        Intent(this, MainActivity2::class.java).apply {
            putExtra(TEXT, imageList)
            resultLauncher.launch(this)
        }
    }

    private fun registerForActivity() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                Log.e("OK","REG:$result")
            }
        }
    }

    private fun initRecycler() {
        adapter = GoatAdapter(object : GoatAdapter.OnClick {
            override fun click(image: Int) {
                imageList.add(image)
            }

            override fun deleteClick(image: Int) {

            }
        })
        adapter.setList(list)
        binding.rvGoat.adapter = adapter
    }

    private fun creatList() {
        for (i in 1..15) {
            list.add(R.drawable.img)
            list.add(R.drawable.img2)
            list.add(R.drawable.img3)
        }
    }

}