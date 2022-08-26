package com.mirkamol.food.ui.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.databinding.FragmentCalculator2Binding
import com.mirkamol.food.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment2 : BaseFragment(R.layout.fragment_calculator2), View.OnClickListener {
    private val binding by viewBinding(FragmentCalculator2Binding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }



    private fun initViews() {
        binding.apply {
            b1.setOnClickListener(this@CalculatorFragment2)
            b2.setOnClickListener(this@CalculatorFragment2)
            b3.setOnClickListener(this@CalculatorFragment2)
            b4.setOnClickListener(this@CalculatorFragment2)
            b5.setOnClickListener(this@CalculatorFragment2)
            b6.setOnClickListener(this@CalculatorFragment2)
            b7.setOnClickListener(this@CalculatorFragment2)
            b8.setOnClickListener(this@CalculatorFragment2)
            b9.setOnClickListener(this@CalculatorFragment2)
            b0.setOnClickListener(this@CalculatorFragment2)
            bdot.setOnClickListener(this@CalculatorFragment2)
            bplus.setOnClickListener(this@CalculatorFragment2)
            bdiv.setOnClickListener(this@CalculatorFragment2)
            bbrac1.setOnClickListener(this@CalculatorFragment2)
            bbrac2.setOnClickListener(this@CalculatorFragment2)
            bpi.setOnClickListener(this@CalculatorFragment2)
            bsin.setOnClickListener(this@CalculatorFragment2)
            bcos.setOnClickListener(this@CalculatorFragment2)
            btan.setOnClickListener(this@CalculatorFragment2)
            binv.setOnClickListener(this@CalculatorFragment2)
            bln.setOnClickListener(this@CalculatorFragment2)
            blog.setOnClickListener(this@CalculatorFragment2)
            bminus.setOnClickListener(this@CalculatorFragment2)
            bmul.setOnClickListener(this@CalculatorFragment2)
            bsqrt.setOnClickListener(this@CalculatorFragment2)
            bequal.setOnClickListener(this@CalculatorFragment2)
            bac.setOnClickListener(this@CalculatorFragment2)
            bc.setOnClickListener(this@CalculatorFragment2)
            bsquare.setOnClickListener(this@CalculatorFragment2)
            bfact.setOnClickListener(this@CalculatorFragment2)

        }
    }

    override fun onClick(view: View?) {
        binding.apply {
            when (view?.id) {
                R.id.b1 -> {
                    idInput.text = (idInput.text.toString() + "1")
                }
                R.id.b2 -> {
                    idInput.text = (idInput.text.toString() + "2")
                }
                R.id.b3 -> {
                    idInput.text = (idInput.text.toString() + "3")
                }
                R.id.b4 -> {
                    idInput.text = (idInput.text.toString() + "4")
                }
                R.id.b5 -> {
                    idInput.text = (idInput.text.toString() + "5")
                }
                R.id.b6 -> {
                    idInput.text = (idInput.text.toString() + "6")
                }
                R.id.b7 -> {
                    idInput.text = (idInput.text.toString() + "7")
                }
                R.id.b8 -> {
                    idInput.text = (idInput.text.toString() + "8")
                }
                R.id.b9 -> {
                    idInput.text = (idInput.text.toString() + "9")
                }
                R.id.b0 -> {
                    idInput.text = (idInput.text.toString() + "0")
                }
                R.id.bdot -> {
                    idInput.text = (idInput.text.toString() + ".")
                }
                R.id.bplus -> {
                    idInput.text = (idInput.text.toString() + "+")
                }
                R.id.bdiv -> {
                    idInput.text = (idInput.text.toString() + "/")
                }
                R.id.bbrac1 -> {
                    idInput.text = (idInput.text.toString() + "(")
                }
                R.id.bbrac2 -> {
                    idInput.text = (idInput.text.toString() + ")")
                }
                R.id.bpi -> {
                    idInput.text = (idInput.text.toString() + "3.142")
                    idOutPut.text = (bpi.text.toString())
                }
                R.id.bsin -> {
                    idInput.text = (idInput.text.toString() + "sin")
                }
                R.id.bcos -> {
                    idInput.text = (idInput.text.toString() + "cos")
                }
                R.id.btan -> {
                    idInput.text = (idInput.text.toString() + "tan")
                }
                R.id.binv -> {
                    idInput.text = (idInput.text.toString() + "^" + "(-1)")
                }
                R.id.bln -> {
                    idInput.text = (idInput.text.toString() + "ln")
                }
                R.id.blog -> {
                    idInput.text = (idInput.text.toString() + "log")
                }
                R.id.bminus -> {
                    val str: String = idInput.text.toString()
                    if (str.isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number..",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (!str.get(index = str.length - 1).equals("-")) {
                            idInput.text = (idInput.text.toString() + "-")
                        }
                    }

                }
                R.id.bmul -> {
                    val str: String = idInput.text.toString()
                    if (str.isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number..",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (!str.get(index = str.length - 1).equals("*")) {
                            idInput.text = (idInput.text.toString() + "*")
                        }
                    }

                }
                R.id.bsqrt -> {
                    if (idInput.text.toString().isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number..",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val str: String = idInput.text.toString()
                        val r = Math.sqrt(str.toDouble())
                        val result = r.toString()
                        idInput.text = result
                    }
                }
                R.id.bequal -> {
                    val str: String = idInput.text.toString()
                    if (str.isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number..",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val result: Double = evaluate(str)
                        val r = result.toString()
                        idInput.text = r
                        idOutPut.text = str
                    }
                }
                R.id.bac -> {
                    idInput.text = ""
                    idOutPut.text = ""
                }
                R.id.bc -> {
                    var str: String = idInput.text.toString()
                    if (!str.equals("")) {
                        str = str.substring(0, str.length - 1)
                        idInput.text = str
                    }
                }
                R.id.bsquare -> {
                    if (idInput.text.toString().isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number..",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val d: Double = idInput.text.toString().toDouble()
                        val square = d * d
                        idInput.text = square.toString()
                        idOutPut.text = "$d²"
                    }
                }
                R.id.bfact -> {
                    if (idInput.text.toString().isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number..",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val value: Int = idInput.text.toString().toInt()
                        val fact: Int = factorial(value)
                        idInput.text = fact.toString()
                        idOutPut.text = "$value`!"
                    }
                }

            }
        }
    }

    fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    fun evaluate(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0
            fun nextChar() {
                ch = if (++pos < str.length) str[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.code)) x += parseTerm() // addition
                    else if (eat('-'.code)) x -= parseTerm() // subtraction
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.code)) x *= parseFactor() // multiplication
                    else if (eat('/'.code)) x /= parseFactor() // division
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()
                var x: Double
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.code && ch <= 'z'.code) {
                    while (ch >= 'a'.code && ch <= 'z'.code) nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    if (func == "sqrt") Math.sqrt(x)
                    else if (func == "sin") Math.sin(
                        Math.toRadians(x)
                    ) else if (func == "cos") Math.cos(
                        Math.toRadians(x)
                    ) else if (func == "tan")
                        Math.tan(Math.toRadians(x))
                    else if (func == "log")
                        Math.log10(x)
                    else if (func == "ln") Math.log(x)
                    else throw RuntimeException(
                        "Unknown function: $func"
                    )
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                if (eat('^'.code)) x = Math.pow(x, parseFactor()) // exponentiation
                return x
            }
        }.parse()
    }

}