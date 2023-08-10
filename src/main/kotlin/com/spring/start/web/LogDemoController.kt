package com.spring.start.web

import com.spring.start.common.MyLogger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.ObjectProvider
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class LogDemoController(
    val logDemoService: LogDemoService,
    val myLoggerProvider: ObjectProvider<MyLogger>
) {
    @RequestMapping("log-demo")
    @ResponseBody
    fun logDemo(request: HttpServletRequest): String {
        val requestURL = request.requestURL.toString()
        val myLogger = myLoggerProvider.getObject()
        myLogger.requestURL = requestURL

        myLogger.log("controller test")
        logDemoService.logic("testId")
        return "OK"
    }

}