package es.iessaladillo.pedrojoya.tipcalculator.model

import java.lang.IllegalArgumentException
import kotlin.math.ceil


// TipCalculator class. Its constructor receives bill, percentage and diners

class TipCalculator(private val bill: Float, private val percentage: Float, private val diners: Int) {

    init {
        negative(bill,percentage,diners)
    }

    fun calculateTip(): Float {
        return bill*percentage/100
    }

    fun calculateTotal(): Float {
        return bill + calculateTip()
    }

    fun calculatePerDiner(): Float {
        return calculateTotal()/diners
    }

    fun calculatePerDinerRounded(): Float {
       return ceil(calculatePerDiner().toDouble()).toFloat()
    }

    private fun negative(bill: Float, percentage: Float, diners: Int) {
        if(bill<0||percentage<0||diners<0){
            throw IllegalArgumentException("Number not valid")
        }
    }
}