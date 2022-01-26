package com.prampus.soundpoolpractice

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.prampus.soundpoolpractice.databinding.ActivityMain2Binding
import com.prampus.soundpoolpractice.databinding.ActivityMainBinding

class MainActivity2 : BaseActivity() {

    lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        binding.button.setOnClickListener {
            onSoundPlay()
        }
    }
}