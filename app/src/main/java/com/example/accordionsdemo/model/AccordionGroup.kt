package com.example.accordionsdemo.model

class AccordionGroup {
    companion object{
        val modelTechStocks = ModelAccordion(
            header = "Technology Stocks",
            rows = mutableListOf(
                ModelAccordion.Row(security = "AAPL", "$328.00"),
                ModelAccordion.Row(security = "GOOGL", "$328.00"),
                ModelAccordion.Row(security = "NFLX", "$198.00"),
                ModelAccordion.Row(security = "META", "$200.00"),
                ModelAccordion.Row(security = "TSLA", "$769.16"),
            )
        )
        val modelEnergyStocks = ModelAccordion(
            header = "Energy Stocks",
            rows = mutableListOf(
                ModelAccordion.Row(security = "MPC", "$96.56"),
                ModelAccordion.Row(security = "CVX", "179.71"),
                ModelAccordion.Row(security = "DVN", "$77.13"),
                ModelAccordion.Row(security = "XOM", "$98.48"),
                ModelAccordion.Row(security = "XPRO", "$13.86"),
            )
        )
        val modelDividendStocks = ModelAccordion(
            header = "Dividend Stocks",
            rows = mutableListOf(
                ModelAccordion.Row(security = "JNJ", "$178.83"),
                ModelAccordion.Row(security = "PG", "$148.63"),
                ModelAccordion.Row(security = "KO", "$64.12"),
                ModelAccordion.Row(security = "BAC", "$37.42"),
                ModelAccordion.Row(security = "MA", "$333.33"),
            )
        )
        val angina = ModelAccordion(
            header = "Angina",
            rows = emptyList()
        )
        val group : List<ModelAccordion>
                = listOf(modelTechStocks,modelEnergyStocks,modelDividendStocks,angina)

        fun getList() : List<ModelAccordion>{
            return group
        }
        fun hasChild(modelObject : ModelAccordion) : Boolean{
            if(modelObject.rows.isEmpty()){
                return false
            }
            return true
        }
    }

}