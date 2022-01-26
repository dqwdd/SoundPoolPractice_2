package com.prampus.soundpoolpractice

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    private lateinit var soundPool: SoundPool

    private val soundIdMap = hashMapOf<String, Int>()
    private val streamIdMap = hashMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SoundPool.Builder()
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
                )
                .setMaxStreams(1) // 동시에 재생 가능한 사운드 최대 수
                .build()
        } else {
            SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }

        soundPool.apply {
            soundIdMap["sound1"] = load(mContext, R.raw.sound_dingdong, 1)

            setOnLoadCompleteListener { soundPool, sampleId, status ->
                Toast.makeText(mContext, "load complete", Toast.LENGTH_SHORT).show()
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }

    fun onSoundPlay() {
        streamIdMap["sound1"] = soundPool.play(soundIdMap["sound1"]!!, 0.5f, 0.5f, 1, 0, 1f)
    }


}