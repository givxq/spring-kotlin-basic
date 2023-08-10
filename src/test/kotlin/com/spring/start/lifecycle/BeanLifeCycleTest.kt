package com.spring.start.lifecycle

import io.kotest.core.spec.style.ShouldSpec
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest : ShouldSpec({
    lateinit var ac: ConfigurableApplicationContext

    beforeContainer {
        ac = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
    }

    context("Bean LifeCycle Test") {
        should("get beans") {
            val client = ac.getBean(NetworkClient::class.java)
            ac.close()
        }

    }

}) {
    @Configuration
    internal class LifeCycleConfig {
        @Bean
        fun networkClient() = NetworkClient("http://hello-spring.dev")
    }
}