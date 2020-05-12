package ru.gidline.app.screen.main.view

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.gidline.app.R
import java.io.Serializable

class WantWorkFragment : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View = LayoutInflater.from(activity!!).inflate(R.layout.fragment_wantshedule,null)
        val dialog:AlertDialog = AlertDialog.Builder(activity!!).setView(view).create()
        var flag:Int=0
        var list:ArrayList<String> = arrayListOf()
        val radioLine: RadioButton = view.findViewById(R.id.item_radio_prof)
        val radioLine1: RadioButton = view.findViewById(R.id.item_radio_prof_1)
        val radioLine2: RadioButton = view.findViewById(R.id.item_radio_time_prof_2)
        val radioLine4: RadioButton = view.findViewById(R.id.item_radio_time_prof_4)
        val radioLine5: RadioButton = view.findViewById(R.id.item_radio_time_prof_5)
        val radioLine6: RadioButton = view.findViewById(R.id.item_radio_time_prof_6)
        val radioLine7: RadioButton = view.findViewById(R.id.item_radio_time_prof_7)
        val radioLine8: RadioButton = view.findViewById(R.id.item_radio_time_prof_8)
        val radioLine9: RadioButton = view.findViewById(R.id.item_radio_time_prof_9)
        val radioLine10: RadioButton = view.findViewById(R.id.item_radio_time_prof_10)
        val radioLine11: RadioButton = view.findViewById(R.id.item_radio_time_prof_11)
        val textWork: TextView = view.findViewById(R.id.text_prof)
        val textWork1: TextView = view.findViewById(R.id.text_prof_1)
        val textWork2: TextView = view.findViewById(R.id.text_prof_2)
        val textWork4: TextView = view.findViewById(R.id.text_prof_4)
        val textWork5: TextView = view.findViewById(R.id.text_prof_5)
        val textWork6: TextView = view.findViewById(R.id.text_prof_6)
        val textWork7: TextView = view.findViewById(R.id.text_prof_7)
        val textWork8: TextView = view.findViewById(R.id.text_prof_8)
        val textWork9: TextView = view.findViewById(R.id.text_prof_9)
        val textWork10: TextView = view.findViewById(R.id.text_prof_10)
        val textWork11: TextView = view.findViewById(R.id.text_prof_11)
        val editWork:EditText = view.findViewById(R.id.edit_proof)
        val btnProof:ImageButton = view.findViewById(R.id.btn_proof)
        radioLine.setOnClickListener {
            if (flag < 5) {
                radioLine.isChecked = true
                list.add(textWork.text.toString()+"\n")
                flag++
            }
        }
        radioLine1.setOnClickListener {
            if (flag < 5) {
                radioLine1.isChecked = true
                list.add(textWork1.text.toString()+"\n")
                flag++
            }
        }
        radioLine2.setOnClickListener {
            if (flag < 5) {
                radioLine2.isChecked = true
                list.add(textWork2.text.toString()+"\n")
                flag++
            }
        }
        radioLine4.setOnClickListener {
            if (flag < 5) {
                radioLine4.isChecked = true
                list.add(textWork4.text.toString()+"\n")
                flag++
            }
        }
        radioLine5.setOnClickListener {
            if (flag < 5) {
                radioLine5.isChecked = true
                list.add(textWork5.text.toString()+"\n")
                flag++
            }
        }
        radioLine6.setOnClickListener {
            if (flag <5) {
                radioLine6.isChecked = true
                list.add(textWork6.text.toString()+"\n")
                flag++
            }
        }
        radioLine7.setOnClickListener {
            if (flag < 5) {
                radioLine7.isChecked = true
                list.add(textWork7.text.toString()+"\n")
                flag++
            }
        }
        radioLine8.setOnClickListener {
            if (flag <5) {
                radioLine8.isChecked = true
                list.add(textWork8.text.toString()+"\n")
                flag++
            }
        }
        radioLine9.setOnClickListener {
            if (flag <5) {
                radioLine9.isChecked = true
                list.add(textWork9.text.toString()+"\n")
                flag++
            }
        }
        radioLine10.setOnClickListener {
            if (flag <5) {
                radioLine10.isChecked = true
                list.add(textWork10.text.toString()+"\n")
                flag++
            }
        }
        radioLine11.setOnClickListener {
            if (flag<5) {
                radioLine11.isChecked = true
                list.add(textWork11.text.toString()+"\n")
                flag++

            }
        }
        btnProof.setOnClickListener {
            val intent = Intent()
            intent.putExtra("workList",list)
            intent.putExtra("editWorkList",editWork.text.toString())
            targetFragment?.onActivityResult(4,Activity.RESULT_OK,intent)
            dialog.dismiss()
        }
        return dialog
    }
}