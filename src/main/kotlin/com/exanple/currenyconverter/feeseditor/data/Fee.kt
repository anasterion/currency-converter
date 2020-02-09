package com.exanple.currenyconverter.feeseditor.data

import javax.persistence.*

@Entity
@Table(name = "fees")
data class Fee(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "base")
        val base: String = "",

        @Column(name = "to_currency")
        val toCurrency: String = "",

        @Column(name = "fee")
        var fee: Double? = null)