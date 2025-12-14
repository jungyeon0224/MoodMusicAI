package com.example.moodmusicai.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.moodmusicai.data.MoodClassifier
import com.example.moodmusicai.data.MusicRepository
import com.example.moodmusicai.model.Song

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val classifier = remember { MoodClassifier() }
    val repo = remember { MusicRepository(context) }

    var input by remember { mutableStateOf("") }
    var mood by remember { mutableStateOf<String?>(null) }
    var songs by remember { mutableStateOf<List<Song>>(emptyList()) }

    val moodText = when (mood) {
        "positive" -> "오늘은 긍정적인 기분이에요 😊"
        "neutral" -> "오늘은 평온한 기분이에요 😐"
        "negative" -> "오늘은 조금 우울한 기분이에요 😢"
        else -> "기분을 입력해보세요"
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("MoodMusic AI") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("오늘 기분은 어때요?", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("예: 오늘 너무 피곤하고 힘들어...") },
                minLines = 3
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    val result = classifier.classify(input)
                    mood = result
                    songs = repo.getSongsForMood(result)
                },
                enabled = input.isNotBlank()
            ) {
                Text("추천받기 🎵")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(moodText, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(songs) { song ->
                    SongItem(song)
                }
            }
        }
    }
}

@Composable
private fun SongItem(song: Song) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(song.url))
                context.startActivity(intent)
            }
    ) {
        Column(Modifier.padding(12.dp)) {
            Text(song.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(song.artist)
        }
    }
}
