package ru.ucoz.rezept_day.percentage.model

class MyCalculete {
    companion object {

        var in_number: Double = 0.0
        var in_pers: Double = 0.0

        fun getPersentOfNumber():String {
            val result = in_number * in_pers / 100
            return result.toString()
        }

        fun getNumberOfNumberPercent():String {
            val result = in_number / in_pers * 100
            return result.toString()
        }

        fun getIncrease():String {
            val result = in_number + (in_number * in_pers / 100)
            return result.toString()
        }
        fun getDecrease():String {
            val result = in_number - (in_number * in_pers / 100)
            return result.toString()
        }
    }
}