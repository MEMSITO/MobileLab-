package com.mems.lab

class MainMethods {
        private val stats = mutableMapOf<String, Int>()
        fun addText(text: String): Map<String, Int> {
            text.trim()
                .lowercase()
                .split("\\W+".toRegex())
                .filter { it.isNotBlank() }
                .forEach { word ->
                    stats[word] = stats.getOrDefault(word, 0) + 1
                }
            return stats.toMap()
        }
        fun printTo(): String =
            if (stats.isEmpty()) "Словарь пуст!!!\nВведите что-нибудь в поле ввода!!!"
            else stats.entries.joinToString(separator = "\n") { (k, v) ->
                "Слово: $k  →  встретилось $v раз(а)"
            }
        fun clearStats(){
            stats.clear()
        }


}
