package com.exanple.currenyconverter.feeseditor.controllers

import com.exanple.currenyconverter.feeseditor.daos.FeesEditorDao
import com.exanple.currenyconverter.feeseditor.data.Fee
import com.exanple.currenyconverter.feeseditor.facades.FeesEditorFacade
import com.exanple.currenyconverter.helpers.CurrencyProvider
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping(value = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
class FeesEditorController(private val feesEditorFacade: FeesEditorFacade) {

    @GetMapping("/{base}")
    fun getCurrencies(@PathVariable base: String): ResponseEntity<Map<String, String>> {
        val uri = "https://api.exchangeratesapi.io/latest?base=${base}"
        val json = RestTemplate().getForObject(uri, String::class.java)
        return ResponseEntity(json?.let { CurrencyProvider.getRatesForCurrency(json) }, HttpStatus.OK)
    }

    @PostMapping("/add")
    fun addFee(@RequestBody data: Fee): ResponseEntity<String> {
        feesEditorFacade.addFee(data)

        return ResponseEntity.ok("")
    }
}