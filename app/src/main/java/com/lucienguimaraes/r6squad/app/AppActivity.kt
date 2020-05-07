package com.lucienguimaraes.r6squad.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucienguimaraes.r6squad.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showHome()
    }

    private fun showHome() {
        val appComponent = (applicationContext as R6CompanionApplication).applicationComponent
        appComponent.koordinator().showNewsList(binding.rootView)
    }
}
