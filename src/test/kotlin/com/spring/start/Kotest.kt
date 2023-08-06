package com.spring.start

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class Kotest : FunSpec({

    beforeEach {
        println("+++ before each")
    }

    test("funSpec test") {
        println("test")
    }
    afterEach {
        println("+++ after each")
    }
})

class KoShouldTest : ShouldSpec({
   context("권리 배정 테스트") {
       should("세금 계산") {
           var tax = BigDecimal.ZERO
           tax += BigDecimal.TEN

           println("in tax test")
           tax shouldBe BigDecimal(10)
       }
   }

    context("다른 권리 test") {
        beforeEach {
            println("+++ before each")
        }

        should("before each 를 위한 테스트") {
            println("in test")
        }
    }
})
