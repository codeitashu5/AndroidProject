package com.ashupandey.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var weightEditText:EditText
    lateinit var  heightEditText:EditText
    lateinit var  bmiText : TextView
    lateinit var  imageView :ImageView
    lateinit var textComment: TextView
    lateinit var buttonCalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        bmiText = findViewById(R.id.bmi_text)
        imageView= findViewById(R.id.image_bmi)
        textComment = findViewById(R.id.comment_text_view)
        buttonCalculate = findViewById(R.id.button_calcuate)
    }


    fun calculateBmi(view:View)
    {
        val weight : String= weightEditText.text.toString()
        val height : String = heightEditText.text.toString()



        //based on bmi the image will be shown
        if(weightEditText.text.length!=0 && heightEditText.text.length!=0)
        {
            val bmi = (weight.toFloat() /(height.toFloat()*height.toFloat()))
            bmiText.text= String.format("%.2f",bmi)

            if(bmi<19)
            {
                imageView.setImageResource(R.drawable.ic_underweight)
                textComment.text="UNDER WEIGHT"
                acessVisiblity()
                view.visibility = View.INVISIBLE

            }

            else if(bmi>=19&&bmi<=24)
            {
                imageView.setImageResource(R.drawable.ic_healthy)
                textComment.text="NORMAL"
                acessVisiblity()
                view.visibility = View.INVISIBLE
            }

            else if(bmi>24&&bmi<=30)
            {
                imageView.setImageResource(R.drawable.ic_overweight)
                textComment.text="OVER WEIGHT"
                acessVisiblity()
                view.visibility = View.INVISIBLE
                //reset the process
            }

            else
            {
                imageView.setImageResource(R.drawable.ic_obesity)
                textComment.text="OBESIED"
                acessVisiblity()
                view.visibility = View.INVISIBLE
                //reset the process
            }
        }

        else
        {
            //produce a toast that says that fill all the values
            val text = "Input the required values"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext,text,duration)
            toast.show()

        }


    }

    private fun acessVisiblity()
    {
        imageView.visibility=View.VISIBLE
        bmiText.visibility=View.VISIBLE
        textComment.visibility=View.VISIBLE

        heightEditText.visibility=View.INVISIBLE
        weightEditText.visibility=View.INVISIBLE
    }

    fun reset(view:View)
    {

        imageView.visibility=View.INVISIBLE
        bmiText.visibility=View.INVISIBLE
        textComment.visibility=View.INVISIBLE


        heightEditText.setText("")
        weightEditText.setText("")


        heightEditText.visibility=View.VISIBLE
        weightEditText.visibility=View.VISIBLE
        buttonCalculate.visibility=View.VISIBLE
    }


}