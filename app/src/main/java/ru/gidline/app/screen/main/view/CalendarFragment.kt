package ru.gidline.app.screen.main.view

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.gidline.app.R
import java.util.*

class CalendarFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View? = LayoutInflater.from(activity).inflate(R.layout.date_dialog,null,false)
        val datePicker = view?.findViewById<DatePicker>(R.id.date_picker)
        val calendar:Calendar = Calendar.getInstance()
        datePicker?.minDate = calendar.timeInMillis
        datePicker?.maxDate = (calendar.timeInMillis+1123200000)
        return AlertDialog.Builder(requireActivity()).setPositiveButton("Ok"){dialog, which -> val year = datePicker!!.year
            val month = datePicker!!.month
            val day = datePicker.dayOfMonth
            val intent = Intent()
            intent.putExtra("day",day)
            intent.putExtra("month",month)
            intent.putExtra("year",year)
            targetFragment!!.onActivityResult(targetRequestCode,Activity.RESULT_OK,intent)

        }.setView(view).create()
    }
}