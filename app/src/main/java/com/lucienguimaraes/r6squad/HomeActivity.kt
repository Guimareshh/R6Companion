package com.lucienguimaraes.r6squad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var githubRepository: GithubRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as R6CompanionApplication).applicationComponent.injectHomeActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        CoroutineScope(Dispatchers.IO).launch {
            githubRepository.requestRepo().forEach {
                Log.d("coroutine", "Repo name is : ${it.name}")
            }
        }
    }
}
