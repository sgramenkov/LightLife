package com.example.finalproject.ui.passingcourse


import android.os.Bundle
import com.example.finalproject.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer


class VideoPlayActivity : YouTubeBaseActivity() {

    private val API_KEY: String = "AIzaSyC8EYVLqhmfy7fZX7mddm_M2G2BZKgXIic"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)

        val youtubePlayerView = findViewById<YouTubePlayerView>(R.id.youtubePlayerView)
        playVideo(intent.getStringExtra("ID_VIDEO_YOUTUBE")!!, youtubePlayerView)
    }


    private fun playVideo(videoId: String, youTubePlayerView: YouTubePlayerView) {
        //initialize youtube player view
        youTubePlayerView.initialize(API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider,
                    youTubePlayer: YouTubePlayer, b: Boolean
                ) {
                    youTubePlayer.cueVideo(videoId)
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider,
                    youTubeInitializationResult: YouTubeInitializationResult
                ) {

                }
            })
    }

}
