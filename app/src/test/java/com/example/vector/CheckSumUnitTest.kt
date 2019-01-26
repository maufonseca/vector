package com.example.vector

import com.example.vector.presentation.main.CheckSumUtils
import org.junit.Test
import org.junit.Assert.*

// These unitary test will certify the core sum verification method work correctly

class CheckSumUnitTest {

    @Test
    fun testHappyCase() {
        val numbers = listOf(-1,0)
        assertFalse(CheckSumUtils.checkSum(numbers, 0).existence)
        assertTrue(CheckSumUtils.checkSum(numbers, -1).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, -0).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, 1).existence)
    }

    @Test
    fun testZero() {
        val numbers = listOf(-2,0,1,2,3)
        assertFalse(CheckSumUtils.checkSum(numbers, -3).existence)
        assertTrue(CheckSumUtils.checkSum(numbers, 0).existence)
        assertTrue(CheckSumUtils.checkSum(numbers, -2).existence)
        assertTrue(CheckSumUtils.checkSum(numbers, -1).existence)
        assertTrue(CheckSumUtils.checkSum(numbers, 2).existence)
        assertTrue(CheckSumUtils.checkSum(numbers, 3).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, 6).existence)
    }

    @Test
    fun testZero2() {
        val numbers = listOf(-2,2)
        assertTrue(CheckSumUtils.checkSum(numbers, 0).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, -2).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, -1).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, 2).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, 4).existence)
        assertFalse(CheckSumUtils.checkSum(numbers, -4).existence)
    }

}
