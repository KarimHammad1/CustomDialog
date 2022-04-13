package com.example.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var imageButton:ImageButton?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton=findViewById(R.id.imageButton)
        //Snackbar
        imageButton?.setOnClickListener {view->
            Snackbar.make(view,"You have Clicked the image",Snackbar.LENGTH_LONG).show()
        }
        //Alert Dialog
        val alertDialog:Button=findViewById(R.id.btn_alert_dialog)

        alertDialog.setOnClickListener { view->

            //function to create the alert dialog
            alertDialogFunction()
        }
        val customDialog:Button=findViewById(R.id.btn_custom_dialog)

        customDialog.setOnClickListener { view->
            customDialogFunction()
        }
        val customProgressBar:Button=findViewById(R.id.btn_custom_progress)
        customProgressBar.setOnClickListener { view->
            customProgressBarFunction()
        }


    }

    private fun customProgressBarFunction() {
        val customProgressDialog=Dialog(this)
        //set the screen layout
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        //start the dialog and display it on screen
        customProgressDialog.show()
    }

    private fun alertDialogFunction(){
        //use the Builder class for convenient dialog construction
        val builder=AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Alert")
        //set message for alert dialog
        builder.setMessage("This is alert Dialog. Which is used to show alerts in our app")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes"){dialogInterface,which->
            Toast.makeText(applicationContext,"Clicked yes",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()//Dialog will be dismissed
        }
        //performing cancel action
        builder.setNeutralButton("Cancel"){dialogInterface,which->
            Toast.makeText(applicationContext,"Clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()//Dialog will be dismissed
        }
        //performing negative
        builder.setNegativeButton("No"){dialogInterface,which->
            Toast.makeText(applicationContext,"Clicked No",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()//Dialog will be dismissed
        }
        //create the alertDialog
        val alertDialog:AlertDialog=builder.create()
        alertDialog.setCancelable(false)//will not allow user to cancel after click on screen
        alertDialog.show()
    }
    private fun customDialogFunction(){
        val customDialog=Dialog(this)
        /*set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen .
        */
        customDialog.setContentView(R.layout.dialog_custom)
       customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener(View.OnClickListener {
           Toast.makeText(applicationContext,"Submit button clicked",Toast.LENGTH_LONG).show()
           customDialog.dismiss()
       })
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"cancel button clicked",Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        })
        customDialog.setCancelable(false)
        customDialog.show()


    }
}