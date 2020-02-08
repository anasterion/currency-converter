package com.exanple.currenyconverter

import com.exanple.currenyconverter.feeseditor.data.Fee
import org.hibernate.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataSourceConfiguration {

//    @Bean
//    fun sessionFactory(): SessionFactory {
//        return org.hibernate.cfg.Configuration()
//                .addAnnotatedClass(Fee::class.java)
//                .configure()
//                .buildSessionFactory()
//    }
}