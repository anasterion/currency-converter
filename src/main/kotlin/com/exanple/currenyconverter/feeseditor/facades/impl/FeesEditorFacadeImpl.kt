package com.exanple.currenyconverter.feeseditor.facades.impl

import com.exanple.currenyconverter.feeseditor.daos.FeesEditorDao
import com.exanple.currenyconverter.feeseditor.data.Fee
import com.exanple.currenyconverter.feeseditor.facades.FeesEditorFacade
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class FeesEditorFacadeImpl(private val feesEditorDao: FeesEditorDao) : FeesEditorFacade {
    private val DEFAULT_FEE = 0.5
    private val LOGGER = LoggerFactory.getLogger(FeesEditorFacadeImpl::class.java)

    override fun addFee(data: Fee) {
        data.fee?.let { feesEditorDao.addFee(data) }
        data.fee = DEFAULT_FEE
        feesEditorDao.addFee(data)
    }

    override fun getFeesList() = feesEditorDao.getFeesList()
}