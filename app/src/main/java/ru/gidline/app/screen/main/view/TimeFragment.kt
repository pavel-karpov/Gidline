package ru.gidline.app.screen.main.view

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.*
import org.jetbrains.anko.find
import ru.gidline.app.R
import ru.gidline.app.screen.search.filter.view.RadioButton

class TimeFragment :DialogFragment(){
    companion object{lateinit var builder:AlertDialog
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View = LayoutInflater.from(activity).inflate(R.layout.dialog_time,null,false)
        val intent = Intent()
        var flag:Int=0
        builder = AlertDialog.Builder(requireActivity()).setView(view).setPositiveButton("OK"){dialog, which ->
            targetFragment?.onActivityResult(2,Activity.RESULT_OK, intent) }.create()
        var list:ArrayList<String> = arrayListOf()
        val radioLine: android.widget.RadioButton = view.findViewById(R.id.radio_time_1)
        val radioLine1: android.widget.RadioButton = view.findViewById(R.id.radio_time_2)
        val radioLine2: android.widget.RadioButton = view.findViewById(R.id.radio_time_3)
        val radioLine3: android.widget.RadioButton = view.findViewById(R.id.radio_time_4)
        val radioLine4: android.widget.RadioButton = view.findViewById(R.id.radio_time_5)
        val radioLine5: android.widget.RadioButton = view.findViewById(R.id.radio_time_6)
        val radioLine6: android.widget.RadioButton = view.findViewById(R.id.radio_time_7)
        val radioLine7: android.widget.RadioButton = view.findViewById(R.id.radio_time_8)
        val radioLine8: android.widget.RadioButton = view.findViewById(R.id.radio_time_9)
        val radioLine9: android.widget.RadioButton = view.findViewById(R.id.radio_time_10)
        val radioLine10: android.widget.RadioButton = view.findViewById(R.id.radio_time_11)
        val radioLine11: android.widget.RadioButton = view.findViewById(R.id.radio_time_12)
        val textWork: TextView = view.findViewById(R.id.text_time_1)
        val textWork1: TextView = view.findViewById(R.id.text_time_2)
        val textWork2: TextView = view.findViewById(R.id.text_time_3)
        val textWork3: TextView = view.findViewById(R.id.text_time_4)
        val textWork4: TextView = view.findViewById(R.id.text_time_5)
        val textWork5: TextView = view.findViewById(R.id.text_time_6)
        val textWork6: TextView = view.findViewById(R.id.text_time_7)
        val textWork7: TextView = view.findViewById(R.id.text_time_8)
        val textWork8: TextView = view.findViewById(R.id.text_time_9)
        val textWork9: TextView = view.findViewById(R.id.text_time_10)
        val textWork10: TextView = view.findViewById(R.id.text_time_11)
        val textWork11: TextView = view.findViewById(R.id.text_time_12)
        radioLine.setOnClickListener {
            if (flag < 1) {
                if (radioLine.isChecked==false){
                    radioLine.isChecked = true
                    list.add(textWork.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }
            }
        }
        radioLine1.setOnClickListener {
            if (flag < 1) {
                if (radioLine1.isChecked==false){
                    radioLine1.isChecked = true
                    list.add(textWork1.text.toString()+"\n")}
                intent.putExtra("time",list)
                flag++

            }
        }
        radioLine2.setOnClickListener {
            if (flag < 1) {
                if (radioLine2.isChecked==false){
                    radioLine2.isChecked = true
                    list.add(textWork2.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++

                }
            }
        }
        radioLine3.setOnClickListener {
            if (flag < 1) {
                if (radioLine3.isChecked==false){
                    radioLine3.isChecked = true
                    flag++
                    list.add(textWork3.text.toString()+"\n")
                    intent.putExtra("time",list)
                }

            }
        }
        radioLine4.setOnClickListener {
            if (flag < 1) {
                if (radioLine4.isChecked==false){
                    radioLine4.isChecked = true
                    list.add(textWork4.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine5.setOnClickListener {
            if (flag < 1) {
                if (radioLine5.isChecked==false){
                    radioLine5.isChecked = true
                    list.add(textWork5.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine6.setOnClickListener {
            if (flag < 1) {
                if (radioLine6.isChecked==false){
                    radioLine6.isChecked = true
                    list.add(textWork6.text.toString()+"\n")
                    intent?.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine7.setOnClickListener {
            if (flag < 1) {
                if (radioLine7.isChecked==false){
                    radioLine7.isChecked = true
                    list.add(textWork7.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine8.setOnClickListener {
            if (flag < 1) {
                if (radioLine8.isChecked==false){
                    radioLine8.isChecked = true
                    list.add(textWork8.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine9.setOnClickListener {
            if (flag < 1) {
                if (radioLine9.isChecked==false){
                    radioLine9.isChecked = true
                    list.add(textWork9.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine10.setOnClickListener {
            if (flag < 1) {
                if (radioLine10.isChecked==false){
                    radioLine10.isChecked = true
                    list.add(textWork10.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }

            }
        }
        radioLine11.setOnClickListener {
            if (flag < 1) {
                if (radioLine11.isChecked==false){
                    radioLine11.isChecked = true
                    list.add(textWork11.text.toString()+"\n")
                    intent.putExtra("time",list)
                    flag++
                }
            }
        }
        return builder

    }

}



















class ListAdapter(var context: Context,var data:ArrayList<String>):BaseAdapter(){
    val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;

     class ViewHolder() {
        lateinit var textItem:TextView
         lateinit var radioItem:RadioButton
         lateinit var linearItem:LinearLayout

    }
    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    var view:View? = convertView
        var viewHolder:ViewHolder?=null
        if (view==null) {
            viewHolder = ViewHolder()
            view = inflater.inflate(R.layout.item_list_time, null)
            viewHolder.textItem = view!!.findViewById(R.id.item_time)
            viewHolder.radioItem = view!!.findViewById(R.id.item_radio_time)
            viewHolder.linearItem = view!!.findViewById(R.id.linear_item)
            view!!.setTag(viewHolder)
        }
        else {
            viewHolder = view.getTag() as ViewHolder?
        }
        if (viewHolder != null) {
            viewHolder.textItem.text =  data.get(position)
        }
        viewHolder!!.radioItem.setOnClickListener {
            viewHolder.radioItem.setChecked(true)
            viewHolder.linearItem.setBackgroundColor(R.color.colorGrayBackground)
            var intent1 = Intent()
            intent1.putExtra("time",viewHolder.textItem.text)
            //Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show()
        }
        return view!!
    }

    override fun getItem(position: Int): Any {
      return data.get(position)
    }

    override fun getItemId(position: Int): Long {
     return  position.toLong()
    }

    override fun getCount(): Int {
       return data.size
    }

}


