package ru.netology

import masterMaestro
import visaMir
import vkPay
import org.junit.Test

import org.junit.Assert.*
import tarifTransver

class MainKtTest {

    @Test
    fun vkPay_Normal() {
        val amountMonthVk = 10_000_00
        val amountVk = 1_000_00

        val result = vkPay(
            amountMonth = amountMonthVk,
            amount = amountVk
        )
        assertEquals(0,result)
    }

    @Test
    fun vkPay_Month_Limit() {
        val amountMonthVk = 40_000_00
        val amountVk = 1_000_00

        val result = vkPay(
            amountMonth = amountMonthVk,
            amount = amountVk
        )
        assertEquals(-10,result)
    }

    @Test
    fun vkPay_Limit_Now() {
        val amountMonthVk = 10_000_00
        val amountVk = 16_000_00

        val result = vkPay(
            amountMonth = amountMonthVk,
            amount = amountVk
        )
        assertEquals(-2,result)
    }

    @Test
    fun visaMir_Limit_Normal() {
        val  amountVM = 15_000_00
        val amountMonthVM = 10_000_00

        val result = visaMir(
            amountMonth = amountMonthVM,
            amount = amountVM
        )
        assertEquals(11_250,result)
    }

    @Test
    fun visaMir_Limit_Now() {
        val  amountVM = 151000_00
        val amountMonthVM = 75_000_00

        val result = visaMir(
            amountMonth = amountMonthVM,
            amount = amountVM
        )
        assertEquals(-2,result)
    }

    @Test
    fun visaMir_Limit_Month() {
        val  amountVM = 151000_00
        val amountMonthVM = 600_001_00

        val result = visaMir(
            amountMonth = amountMonthVM,
            amount = amountVM
        )
        assertEquals(-1,result)
    }

    @Test
    fun visaMir_Limit_Min() {
        val  amountVM = 1000_00
        val amountMonthVM = 0

        val result = visaMir(
            amountMonth = amountMonthVM,
            amount = amountVM
        )
        assertEquals(35_00,result)
    }

    @Test
    fun masterMaestro_Normal() {
        val  amountMM = 1_000_00
        val amountMonthMM = 10_000_00

        val result = masterMaestro(
            amountMonth = amountMonthMM,
            amount = amountMM
        )
        assertEquals(0,result)
    }

    @Test
    fun masterMaestro_Limit_Month() {
        val  amountMM = 1_000_00
        val amountMonthMM = 75_000_00

        val result = masterMaestro(
            amountMonth = amountMonthMM,
            amount = amountMM
        )
        assertEquals(2600,result)
    }

    @Test
    fun tarifTransver_Normal_Master() {
        val cardTypeTest = "Mastercard"
        val  amountTest = 1_000_00
        val amountMonthTest = 10_000_00

        val result = tarifTransver(
            cardType = cardTypeTest,
            amountMonth = amountMonthTest,
            amount = amountTest
        )
        assertEquals(0,result)
    }

    @Test
    fun tarifTransver_limitMonth_Maestro() {
        val cardTypeTest = "Maestro"
        val  amountTest = 1_000_00
        val amountMonthTest = 80_000_00

        val result = tarifTransver(
            cardType = cardTypeTest,
            amountMonth = amountMonthTest,
            amount = amountTest
        )
        assertEquals(2600,result)
    }

    @Test
    fun tarifTransver_Limit_Month() {
        val cardTypeTest = "Visa"
        val  amountTest = 1_000_00
        val amountMonthTest= 610_000_00

        val result = tarifTransver(
            cardType = cardTypeTest,
            amountMonth = amountMonthTest,
            amount = amountTest
        )
        assertEquals(-1,result)
    }

    @Test
    fun tarifTransver_Limit_Now_Visa() {
        val cardTypeTest = "Visa"
        val  amountTest = 151_000_00
        val amountMonthTest = 10_000_00

        val result = tarifTransver(
            cardType = cardTypeTest,
            amountMonth = amountMonthTest,
            amount = amountTest
        )
        assertEquals(-2,result)
    }

    @Test
    fun tarifTransver_Limit_Now_Mir() {
        val cardTypeTest = "Mir"
        val  amountTest = 151_000_00
        val amountMonthTest = 10_000_00

        val result = tarifTransver(
            cardType = cardTypeTest,
            amountMonth = amountMonthTest,
            amount = amountTest
        )
        assertEquals(-2,result)
    }

    @Test
    fun tarifTransver_VkPay() {
        val cardTypeTest = "VkPay"
        val  amountTest = 1_000_00
        val amountMonthTest = 10_000_00

        val result = tarifTransver(
            cardType = cardTypeTest,
            amountMonth = amountMonthTest,
            amount = amountTest
        )
        assertEquals(0,result)
    }
}