package com.exanple.currenyconverter.feeseditor.controllers

import com.exanple.currenyconverter.feeseditor.data.Fee
import com.exanple.currenyconverter.helpers.CurrencyProvider
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping(value = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
class FeesEditorController {

    @GetMapping("/test")
    fun getTestResponse(): ResponseEntity<Fee> = ResponseEntity(Fee("1", "Test"), HttpStatus.OK)

    @GetMapping("/{base}")
    fun getCurrencies(@PathVariable base: String): ResponseEntity<Map<String, String>> {
        val uri = "https://api.exchangeratesapi.io/latest?base=${base}"
        val result = RestTemplate().getForObject(uri, String::class.java)
        return ResponseEntity(result?.let { CurrencyProvider.getRatesForCurrency(result) } , HttpStatus.OK)
    }
}