package io.icednut.leetcode.exercise.annotation

import org.junit.jupiter.api.Assertions.assertLinesMatch
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path

internal class JunitAnnotationExercise {

    @field:TempDir
    lateinit var folder: Path

    @Test
    fun testUsingTempFolder() {
        val createdFile = folder.resolve("myfile.txt")
        val lines = listOf("a", "b", "c")

        Files.write(createdFile, lines)

        assertAll(
            { assertTrue(Files.exists(createdFile)) },
            { assertLinesMatch(lines, Files.readAllLines(createdFile)) }
        )
    }
}