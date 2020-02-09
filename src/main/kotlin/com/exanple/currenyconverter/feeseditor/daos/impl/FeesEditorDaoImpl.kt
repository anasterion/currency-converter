package com.exanple.currenyconverter.feeseditor.daos.impl

import com.exanple.currenyconverter.feeseditor.daos.FeesEditorDao
import com.exanple.currenyconverter.feeseditor.data.Fee
import org.hibernate.SessionFactory
import org.springframework.stereotype.Repository

@Repository
class FeesEditorDaoImpl(private val sessionFactory: SessionFactory) : FeesEditorDao {

    override fun addFee(data: Fee) {
        val session = sessionFactory.openSession()
        val transaction = session.beginTransaction()
        session.use {
            it.save(data)
            transaction.commit()
        }
    }

    override fun getFeesList(): List<Fee> {
        val session = sessionFactory.openSession()
        var fees: List<Fee> = emptyList()

        session.use {
            val query = it.createQuery("from Fee", Fee::class.java)
            fees = query.list()
        }

        return fees
    }
}