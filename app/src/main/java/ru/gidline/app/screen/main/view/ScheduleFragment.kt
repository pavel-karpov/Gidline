package ru.gidline.app.screen.main.view

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import org.w3c.dom.Text
import ru.gidline.app.R

class ScheduleFragment :DialogFragment(){

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View = LayoutInflater.from(activity!!).inflate(R.layout.fragment_schedule,null)
        val dialog:AlertDialog = AlertDialog.Builder(activity!!).setView(view).create()
        var intent:Intent
        val radioLine:RadioButton = view.findViewById(R.id.item_radio_time)
        val radioLine1:RadioButton = view.findViewById(R.id.item_radio_time_1)
        val radioLine2:RadioButton = view.findViewById(R.id.item_radio_time_2)
        val radioLine3:RadioButton = view.findViewById(R.id.item_radio_time_3)
        val textWork:TextView = view.findViewById(R.id.text_work)
        val textWork1:TextView = view.findViewById(R.id.text_work_1)
        val textWork2:TextView = view.findViewById(R.id.text_work_2)
        val textWork3:TextView = view.findViewById(R.id.text_work_3)
        radioLine.setOnClickListener {
            radioLine.isChecked=true
            intent = Intent()
            intent.putExtra("key_work",textWork.text.toString())
            targetFragment?.onActivityResult(3,Activity.RESULT_OK,intent)
            dialog.dismiss()
        }
        radioLine1.setOnClickListener {
            radioLine1.isChecked=true
            intent = Intent()
            intent.putExtra("key_work",textWork1.text.toString())
            targetFragment?.onActivityResult(3,Activity.RESULT_OK,intent)
            dialog.dismiss()
        }
        radioLine2.setOnClickListener {
            radioLine2.isChecked=true
            intent = Intent()
            intent.putExtra("key_work",textWork2.text.toString())
            targetFragment?.onActivityResult(3,Activity.RESULT_OK,intent)
            dialog.dismiss()
        }
        radioLine3.setOnClickListener {
            radioLine3.isChecked=true
            intent = Intent()
            intent.putExtra("key_work",textWork3.text.toString())
            targetFragment?.onActivityResult(3,Activity.RESULT_OK,intent)
            dialog.dismiss()
        }
        return dialog
    }
}