package com.spring.start.web

import com.spring.start.common.MyLogger
import org.springframework.beans.factory.ObjectProvider
import org.springframework.stereotype.Service

@Service
class LogDemoService(
    private val myLogger: ObjectProvider<MyLogger>
) {
    fun logic(id: String) = myLogger.getObject().log("service id = $id")
}
