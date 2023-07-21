package com.cxq.mobile

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

object SpeakUtil {

    private lateinit var text2speech: TextToSpeech

     fun init(context: Context) {
        text2speech = TextToSpeech(context) {
            if (it == TextToSpeech.SUCCESS) {
                text2speech.language = Locale.CHINA
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
    }

    fun speakText(text: String) {
        text2speech.setSpeechRate(0.9f)
        text2speech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun stopSpeak() {
        text2speech.stop()
    }
}