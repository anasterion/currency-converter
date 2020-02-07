package com.exanple.currenyconverter.currencycalculator.controllers

import com.exanple.currenyconverter.currencycalculator.data.Fee
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
class FeeEditorController {

    @GetMapping("/test")
    fun getTestResponse(): ResponseEntity<Fee> = ResponseEntity(Fee("1", "Test"), HttpStatus.OK)
}