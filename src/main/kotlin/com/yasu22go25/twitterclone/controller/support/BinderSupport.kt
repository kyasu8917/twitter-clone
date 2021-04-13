package com.yasu22go25.twitterclone.controller.support

import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Component
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.InitBinder
import java.text.SimpleDateFormat
import java.util.*

@ControllerAdvice
@Component
class BinderSupport {
    @InitBinder
    fun initBinder(binder: WebDataBinder) {
        val datetimeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        datetimeFormat.isLenient = false
        binder.registerCustomEditor(Date::class.java, "createAt", CustomDateEditor(datetimeFormat, true))
    }
}