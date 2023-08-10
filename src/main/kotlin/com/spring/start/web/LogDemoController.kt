package com.spring.start.web

import com.spring.start.common.MyLogger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class LogDemoController(
    val logDemoService: LogDemoService,
    val myLogger: MyLogger
) {
    @RequestMapping("log-demo")
    @ResponseBody
    fun logDemo(request: HttpServletRequest): String {
        val requestURL = request.requestURL.toString()
        myLogger.requestURL = requestURL

        println("+++ ${myLogger.javaClass}")
        myLogger.log("controller test")
        logDemoService.logic("testId")
        return "OK"
    }

}