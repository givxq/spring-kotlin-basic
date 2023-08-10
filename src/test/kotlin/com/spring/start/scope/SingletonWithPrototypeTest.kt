package com.spring.start.scope

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonWithPrototypeTest : ShouldSpec({

    should("prototype find") {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        listOf(
            ac.getBean(PrototypeBean::class.java), ac.getBean(PrototypeBean::class.java)
        ).forEach {
            it.addCount()
            it.count shouldBe 1
        }
    }

    should("singleton client use prototype") {
        val ac = AnnotationConfigApplicationContext(ClientBeanWithSingleton::class.java, PrototypeBean::class.java)
        var count = 0

        listOf(
            ac.getBean(ClientBeanWithSingleton::class.java), ac.getBean(ClientBeanWithSingleton::class.java)
        ).forEach {
            it.logic() shouldBe ++count
        }
    }

    should("singleton with prototype") {
        val ac = AnnotationConfigApplicationContext(ClientBean::class.java, PrototypeBean::class.java)

        listOf(
            ac.getBean(ClientBean::class.java), ac.getBean(ClientBean::class.java)
        ).forEach {
            it.logic() shouldBe 1
        }
    }

}) {
    @Scope
    internal class ClientBeanWithSingleton(private val prototypeBean: PrototypeBean) {
        fun logic(): Int {
            prototypeBean.addCount()
            return prototypeBean.count
        }
    }

    @Scope
    internal class ClientBean(
        private val prototypeBeanProvider: ObjectProvider<PrototypeBean>
    ) {
        fun logic(): Int {
            val prototypeBean = prototypeBeanProvider.getObject()
            prototypeBean.addCount()
            return prototypeBean.count
        }
    }

    @Scope("prototype")
    internal class PrototypeBean {
        var count = 0
            private set

        fun addCount() = count++

        @PostConstruct
        fun init() = println("PrototypeBean.init $this")

        @PreDestroy
        fun close() = println("PrototypeBean.close $this")
    }
}