package io.icednut.algorithm_study.day02

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val uniquePatternLetter = pattern.toSet().toList()
        val patternMap = s.split(" ")
            .map { elem ->
                elem to 0
            }
            .toMap()

        if (patternMap.keys.size != uniquePatternLetter.size) {
            return false
        }

        val actualMap = patternMap.keys.mapIndexed { index, st ->
            uniquePatternLetter[index] to st
        }.toMap()

        val given = pattern.toList()
            .mapIndexed { index, letter ->
                actualMap[letter]
            }
            .joinToString(" ")

        return given == s
    }
}