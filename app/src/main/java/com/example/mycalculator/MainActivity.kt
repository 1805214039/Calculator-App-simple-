package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var  lastNumeric : Boolean=false
    var lastDot : Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clickOnBtn(view:View)
    {
        screen.append((view as Button).text)
        lastNumeric=true
    }
    fun clearBtn(view: View)
    {
        screen.text=""
        lastNumeric=false
        lastDot=false
    }
    fun clickOnDecimalBtn(view: View)
    {
       if(lastNumeric && !lastDot)
       {
           screen.append(".")
           lastNumeric=false
           lastDot=true
       }
    }
    fun clickOnOperator(view: View)
    {
       if(lastNumeric && !isOperatorAdded(screen.text.toString()))
       {
          screen.append((view as Button).text)
              lastNumeric=false
           lastDot=false
       }
    }
    fun isOperatorAdded(value: String) : Boolean
    {
     return if(value.startsWith("-"))
        {
            false
        }
        else
        {
         value.contains("/")||value.contains("+")||value.contains("-")||value.contains("*")

        }
    }
    fun clickOnEqual(view: View)
    {
        if(lastNumeric)
        {  var em=" "
            var expr =screen.text.toString()
            try {
                if(expr.startsWith("-"))
            {
                expr=expr.substring(1)
            }
                if(expr.contains("-")) {
                    val splitexpr = expr.split("-")
                    var one = splitexpr[0]
                    var two = splitexpr[1]
                        one = em + one
                        screen.text = (one.toDouble() - two.toDouble()).toString()

                    }
               else if(expr.contains("+")) {
                    val splitexpr = expr.split("+")
                    var one = splitexpr[0]
                    var two = splitexpr[1]
                    one = em + one
                    screen.text = (one.toDouble() + two.toDouble()).toString()

                }
                if(expr.contains("*")) {
                    val splitexpr = expr.split("*")
                    var one = splitexpr[0]
                    var two = splitexpr[1]
                    one = em + one
                    screen.text = (one.toDouble() * two.toDouble()).toString()

                }
                if(expr.contains("/")) {
                    val splitexpr = expr.split("/")
                    var one = splitexpr[0]
                    var two = splitexpr[1]
                    one = em + one
                    screen.text = (one.toDouble() / two.toDouble()).toString()

                }

            }
            catch (e:ArithmeticException)
            {
                e.printStackTrace()
            }
        }
    }
}