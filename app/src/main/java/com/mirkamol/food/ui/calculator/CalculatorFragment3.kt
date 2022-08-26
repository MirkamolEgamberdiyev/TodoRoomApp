package com.mirkamol.food.ui.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirkamol.food.R
import com.mirkamol.food.databinding.FragmentCalculator3Binding
import com.mirkamol.food.ui.BaseFragment
import com.mirkamol.food.ui.calculator.adapter.CalculatorAdapter3
import com.mirkamol.food.ui.calculator.adapter.CalculatorAdapter2


class CalculatorFragment3 : BaseFragment(R.layout.fragment_calculator3),
    CalculatorAdapter2.Callbacks {
    private val binding by viewBinding(FragmentCalculator3Binding::bind)
    lateinit var adapter1: CalculatorAdapter3
    lateinit var adapter2: CalculatorAdapter2
    var list1 = ArrayList<String>()
    var list2 = ArrayList<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list1 = arrayListOf(
            "sin", "cos", "tan", "log", "ln", "x!", "x²", "√", "1/x", "÷"
        )
        list2 = arrayListOf(
            "AC", "C", "(", ")",
            "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "π", "0", ".", "="
        )

        setUpAdapter1()
        setUpAdapter2()
        val layoutManager1 = GridLayoutManager(requireContext(), 5)
        binding.recyclerView1.layoutManager = layoutManager1
        val layoutManager2 = GridLayoutManager(requireContext(), 4)
        binding.recyclerView2.layoutManager = layoutManager2

    }

    private fun setUpAdapter2() {
        adapter1 = CalculatorAdapter3(list2) {
            Log.d("TAG", "setUpAdapter2: $it")
            binding.apply {
                when (it) {
                    "AC" -> {
                        idInput.text = ""
                        idOutPut.text = ""
                    }
                    "C" -> {
                        var str: String = idInput.text.toString()
                        if (!str.equals("")) {
                            str = str.substring(0, str.length - 1)
                            idInput.text = str
                        }
                    }

                    "(" -> {
                        idInput.text = (idInput.text.toString() + "(")
                    }
                    ")" -> {
                        idInput.text = (idInput.text.toString() + ")")
                    }
                    "7" -> {
                        idInput.text = (idInput.text.toString() + "7")
                    }
                    "8" -> {
                        idInput.text = (idInput.text.toString() + "8")
                    }
                    "9" -> {
                        idInput.text = (idInput.text.toString() + "9")
                    }
                    "×" -> {
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
                    "4" -> {
                        idInput.text = (idInput.text.toString() + "4")
                    }
                    "5" -> {
                        idInput.text = (idInput.text.toString() + "5")
                    }
                    "6" -> {
                        idInput.text = (idInput.text.toString() + "6")
                    }
                    "-" -> {
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
                    "1" -> {
                        idInput.text = (idInput.text.toString() + "1")
                    }
                    "2" -> {
                        idInput.text = (idInput.text.toString() + "2")
                    }
                    "3" -> {
                        idInput.text = (idInput.text.toString() + "3")
                    }
                    "+" -> {
                        idInput.text = (idInput.text.toString() + "+")

                    }
                    "π" -> {
                        idInput.text = (idInput.text.toString() + "3.142")

                    }
                    "0" -> {

                        idInput.text = (idInput.text.toString() + "0")
                    }
                    "." -> {
                        idInput.text = (idInput.text.toString() + "0")
                    }
                    "=" -> {
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
                }
            }
        }

        binding.recyclerView2.adapter = adapter1
    }

    private fun setUpAdapter1() {
        adapter2 = CalculatorAdapter2(list1, this)
        binding.recyclerView1.adapter = adapter2
    }

    override fun handleData(data: String) {
        Log.d("TAG", "handleUserData: $data")

        binding.apply {
            when (data) {
                "sin" -> {
                    idInput.text = (idInput.text.toString() + "sin")

                }
                "cos" -> {
                    idInput.text = (idInput.text.toString() + "cos")
                }
                "tan" -> {
                    idInput.text = (idInput.text.toString() + "tan")

                }
                "log" -> {
                    idInput.text = (idInput.text.toString() + "log")
                }
                "ln" -> {
                    idInput.text = (idInput.text.toString() + "ln")
                }
                "x!" -> {
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
                "x²" -> {
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
                "√" -> {
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
                "1/x" -> {
                    idInput.text = (idInput.text.toString() + "^" + "(-1)")
                }
                "÷" -> {
                    idInput.text = (idInput.text.toString() + "/")
                }
            }
        }
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


    private fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }
}