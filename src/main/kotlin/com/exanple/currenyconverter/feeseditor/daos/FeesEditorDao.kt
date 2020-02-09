package com.exanple.currenyconverter.feeseditor.daos

import com.exanple.currenyconverter.feeseditor.data.Fee

interface FeesEditorDao {
    fun addFee(data: Fee)

    fun getFeesList(): List<Fee>
}