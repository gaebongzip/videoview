package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import com.example.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private lateinit var videoView: VideoView
    private lateinit var mediaController: MediaController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //    WindowManager.LayoutParams.FLAG_FULLSCREEN)

        videoView = binding.videoView
        mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        var uri = Uri.parse("android.resource://${packageName}/raw/english_word_500");
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.start()
    }


    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}