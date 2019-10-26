package es.iessaladillo.pedrojoya.tipcalculator.ui.main

import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import es.iessaladillo.pedrojoya.tipcalculator.R
import es.iessaladillo.pedrojoya.tipcalculator.model.TipCalculator

class MainActivity : AppCompatActivity() {

    private lateinit var txtBillTextWatcher: TextWatcher
    private lateinit var txtTipPercentTextWatcher: TextWatcher
    private lateinit var txtDinersTextWatcher: TextWatcher
    private lateinit var TipCalculator: TipCalculator
    private lateinit var txtBill: EditText
    private lateinit var txtTip: EditText
    private lateinit var txtPercentage: EditText
    private lateinit var txtDiners: EditText
    private lateinit var txtPerDiner: EditText
    private lateinit var txtTotal: EditText
    private lateinit var txtPerDinerRounded: EditText
    private lateinit var btnResetTip: Button
    private lateinit var btnResetDiners: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun actualizar() {
        if(txtBill.text.toString().equals("")){
            txtBill.setText(getText(R.string.Bill_Default))
        }
        if(txtPercentage.text.toString().equals("")){
            txtPercentage.setText(getText(R.string.txtPercentage))
        }
        if(txtDiners.text.toString().equals("")||txtDiners.text.toString().equals("0")){
            txtDiners.setText(getText(R.string.txtDiners))
        }
        TipCalculator = TipCalculator(txtBill.text.toString().toFloat(), txtPercentage.text.toString().toFloat(), txtDiners.text.toString().toInt())
        txtTip.setText(String.format("%.2f",TipCalculator.calculateTip()).replace(",","."))
        txtTotal.setText(String.format("%.2f",TipCalculator.calculateTotal()).replace(",","."))
        txtPerDiner.setText(String.format("%.2f",TipCalculator.calculatePerDiner()).replace(",","."))
        txtPerDinerRounded.setText(String.format("%.2f",TipCalculator.calculatePerDinerRounded()).replace(",","."))
    }

    private fun setupViews() {
        txtTip= findViewById(R.id.txtTip)
        txtBill= findViewById(R.id.txtBill)
        txtPercentage= findViewById(R.id.txtPercentage)
        txtTotal= findViewById(R.id.txtTotal)
        txtDiners= findViewById(R.id.txtDiners)
        txtPerDiner = findViewById(R.id.txtPerDiner)
        txtPerDinerRounded = findViewById(R.id.txtPerDinerRounded)
        btnResetTip= findViewById(R.id.btnResetTip)
        btnResetDiners= findViewById(R.id.btnResetDiners)
        btnResetTip.setOnClickListener{resetTip()}
        btnResetDiners.setOnClickListener{resetDiners()}
        txtBill.requestFocus()
        txtBillTextWatcher = txtBill.doAfterTextChanged { actualizar() }
        txtTipPercentTextWatcher = txtPercentage.doAfterTextChanged { actualizar() }
        txtDinersTextWatcher = txtDiners.doAfterTextChanged { actualizar() }
}

    private fun resetDiners() {
        txtDiners.requestFocus()
        txtDiners.setText(getText(R.string.txtDiners))
        actualizar()
    }

    private fun resetTip() {
        txtBill.requestFocus()
        txtPercentage.setText(getText(R.string.txtPercentage))
        txtBill.setText(getText(R.string.Bill_Default))
        actualizar()
    }
}
