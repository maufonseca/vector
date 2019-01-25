package com.example.vector

import com.example.vector.presentation.main.CheckSumUtils
import org.junit.Test
import org.junit.Assert.*

class CheckSumUnitTest {

    @Test
    fun testHappyCase() {
        val numbers = listOf(-1,0)
        assertFalse(CheckSumUtils.checkSum(numbers, 0))
        assertTrue(CheckSumUtils.checkSum(numbers, -1))
        assertFalse(CheckSumUtils.checkSum(numbers, -0))
        assertFalse(CheckSumUtils.checkSum(numbers, 1))
    }

    @Test
    fun testZero() {
        val numbers = listOf(-2,0,1,2,3)
        assertFalse(CheckSumUtils.checkSum(numbers, -3))
        assertTrue(CheckSumUtils.checkSum(numbers, 0))
        assertTrue(CheckSumUtils.checkSum(numbers, -2))
        assertTrue(CheckSumUtils.checkSum(numbers, -1))
        assertTrue(CheckSumUtils.checkSum(numbers, 2))
        assertTrue(CheckSumUtils.checkSum(numbers, 3))
        assertFalse(CheckSumUtils.checkSum(numbers, 6))
    }

    @Test
    fun testZero2() {
        val numbers = listOf(-2,2)
        assertTrue(CheckSumUtils.checkSum(numbers, 0))
        assertFalse(CheckSumUtils.checkSum(numbers, -2))
        assertFalse(CheckSumUtils.checkSum(numbers, -1))
        assertFalse(CheckSumUtils.checkSum(numbers, 2))
        assertFalse(CheckSumUtils.checkSum(numbers, 4))
        assertFalse(CheckSumUtils.checkSum(numbers, -4))
    }

}
