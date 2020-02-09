package com.exanple.currenyconverter.helpers

import com.exanple.currenyconverter.feeseditor.data.Fee
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


object CurrencyProvider {

    fun getRatesForCurrency(json: String): Map<String, String> {
        val mapper = jacksonObjectMapper()
        val jsonObject: ObjectNode = mapper.readValue(json, ObjectNode::class.java)
        val rates: JsonNode = jsonObject.get("rates")
        return mapper.convertValue(rates)
    }
}