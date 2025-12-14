package com.example.moodmusicai.data

import android.content.Context
import com.example.moodmusicai.model.Song
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MusicRepository(private val context: Context) {

    private val cache: MutableMap<String, List<Song>> = mutableMapOf()

    fun getSongsForMood(mood: String): List<Song> {
        if (cache.isEmpty()) loadAll()
        return cache[mood.lowercase()] ?: emptyList()
    }

    private fun loadAll() {
        val json = context.assets.open("music_list.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<Map<String, List<Song>>>() {}.type
        val parsed: Map<String, List<Song>> = Gson().fromJson(json, type)
        cache.putAll(parsed)
    }
}
