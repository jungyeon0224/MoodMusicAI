package com.example.moodmusicai.data

class MoodClassifier {
    fun classify(text: String): String {
        val lower = text.lowercase()

        return when {
            lower.contains("행복") || lower.contains("좋아") || lower.contains("기뻐") ||
                    lower.contains("happy") || lower.contains("good") -> "positive"

            lower.contains("우울") || lower.contains("힘들") || lower.contains("슬퍼") ||
                    lower.contains("tired") || lower.contains("sad") -> "negative"

            else -> "neutral"
        }
    }
}
