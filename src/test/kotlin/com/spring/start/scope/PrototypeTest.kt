package com.spring.start.scope

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.equals.shouldNotBeEqual
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class PrototypeTest : ShouldSpec({
    should("test") {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val singletonBean1 = ac.getBean(PrototypeBean::class.java)
        val singletonBean2 = ac.getBean(PrototypeBean::class.java)

        println("singletonBean1 = $singletonBean1")
        println("singletonBean2 = $singletonBean2")

        singletonBean1 shouldNotBeEqual singletonBean2

        ac.close()
    }
}) {
    @Scope("prototype")
    internal class PrototypeBean {

        @PostConstruct
        fun init() = println("PrototypeBean.init")

        @PreDestroy
        fun close() = println("PrototypeBean.close")
    }
}