package com.app.homeexerciseapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.app.base.BaseActivity
import com.app.homeexerciseapp.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    override val bindLayout: (LayoutInflater) -> ActivitySplashScreenBinding
        get() = ActivitySplashScreenBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {
        binding.appVersion.text =
            getString(R.string.app_version, BuildConfig.VERSION_CODE.toString())

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}