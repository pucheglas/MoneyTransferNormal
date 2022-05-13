package ru.netology

import VkPay
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun VkPay_Normal() {
        val amountMonthVk = 10_000_00
        val amountVk = 1_000_00

        val result = VkPay(
            amountMonth = amountMonthVk,
            amount = amountVk
        )
        assertEquals(0,result)
    }

    @Test
    fun vkPay_Month_Limit() {
        val amountMonthVk = 40_000_00
        val amountVk = 1_000_00

        val result = VkPay(
            amountMonth = amountMonthVk,
            amount = amountVk
        )
        assertEquals(-1,result)
    }

    @Test
    fun VkPay_Limit_Now() {
        val amountMonthVk = 10_000_00
        val amountVk = 16_000_00

        val result = VkPay(
            amountMonth = amountMonthVk,
            amount = amountVk
        )
        assertEquals(-2,result)
    }
}