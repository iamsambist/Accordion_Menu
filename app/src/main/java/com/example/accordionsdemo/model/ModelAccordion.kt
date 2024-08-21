package com.example.accordionsdemo.model

data class ModelAccordion(
    val header : String,
    val rows : List<Row>
){
    data class Row(
        val security : String,
        val price  : String
    )
}