package com.prampus.soundpoolpractice

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.prampus.soundpoolpractice.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.tv2.setOnClickListener {
            onSoundPlay()
            val myIntent = Intent(this, MainActivity2::class.java)
            startActivity(myIntent)
        }
    }



//    fun onClickStop(view: View) {
//        soundPool.stop(streamIdMap["sound1"]!!)
//        // soundPool.pause(streamIdMap["sound1"]!!) // 해당 사운드 일시정지
//        // soundPool.autoPause() // 재생중인 사운드 모두 일시정지
//    }



}