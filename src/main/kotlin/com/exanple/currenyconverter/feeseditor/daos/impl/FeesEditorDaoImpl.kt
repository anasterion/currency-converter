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
        session.save(data)
        transaction.commit()
        session.close()
    }
}