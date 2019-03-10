package ru.ucoz.rezept_day.percentage

class MyCalculete {
    companion object {

        var in_number: Double = 0.0
        var in_pers: Double = 0.0

        fun persentOfNumber():String {
            val result = in_number * in_pers / 100
            return result.toString()
        }

        fun numberOfNumberPercent():String {
            val result = in_number / in_pers * 100
            return result.toString()
        }

        fun increase():String {
            val result = in_number + (in_number * in_pers / 100)
            return result.toString()
        }
        fun decrease():String {
            val result = in_number - (in_number * in_pers / 100)
            return result.toString()
        }
    }
}