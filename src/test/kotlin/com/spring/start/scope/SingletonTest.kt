package com.spring.start.scope

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.equals.shouldBeEqual
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonTest : ShouldSpec({
    should("test") {
        val ac = AnnotationConfigApplicationContext(SingletonBean::class.java)

        val singletonBean1 = ac.getBean(SingletonBean::class.java)
        val singletonBean2 = ac.getBean(SingletonBean::class.java)

        println("singletonBean1 = $singletonBean1")
        println("singletonBean2 = $singletonBean2")

        singletonBean1 shouldBeEqual singletonBean2

        ac.close()
    }
}) {
    @Scope("singleton")
    class SingletonBean {

        @PostConstruct
        fun init() = println("SingletonBean.init")

        @PreDestroy
        fun close() = println("SingletonBean.close")
    }
}