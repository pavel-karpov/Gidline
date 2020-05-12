package ru.gidline.app.screen.search.vacancies.vacancy

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.merge_expansion.view.*
import kotlinx.android.synthetic.main.merge_expansion_set.view.*
import org.jetbrains.anko.dip
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import ru.gidline.app.R
import ru.gidline.app.extension.use
import ru.gidline.app.local.model.Vacancy

class ExpansionLayoutSet : LinearLayout, KodeinAware {

    override val kodein by closestKodein()

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    @Suppress("unused")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(attrs)
    }

    @SuppressLint("Recycle")
    private fun init(attrs: AttributeSet?) {
        orientation = VERTICAL
        setPadding(dip(10), dip(12), dip(10), 0)
        View.inflate(context, R.layout.merge_expansion_set, this)
        attrs?.let { set ->
            context.obtainStyledAttributes(set, R.styleable.ExpansionLayout).use {
                getString(R.styleable.ExpansionLayout_text)?.let {
                    tv_name_ex.text = it
                }
            }
        }
        ib_arrow_ex.setOnClickListener {
            if (tv_text_ex.isVisible) {
                ib_arrow_ex.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_right,0,0,0)
                tv_text_ex.isVisible = false
            } else {
                ib_arrow_ex.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down,0,0,0)
                tv_text_ex.isVisible = true
            }
        }
    }

    fun updateText(vacancy: Vacancy) = context.run {
        tv_text_ex.text = when (tv_name_ex.text) {
            getString(R.string.expansion_offer) -> vacancy.offer
            getString(R.string.expansion_responsibility) -> vacancy.responsibility
            getString(R.string.expansion_requirement) -> vacancy.requirement
            else -> ""
        }
    }
    fun updateText(text:List<String>)=context.run {
        tv_text_ex.text = when (tv_name_ex.text){
            getString(R.string.resume)->text[0]
            getString(R.string.resume_right)->text[3]
            getString(R.string.resume_helpws)->text[1]
            getString(R.string.resume_help)->text[4]
            getString(R.string.language)->text[2]
            getString(R.string.days)->text[5]
            getString(R.string.first_always1)->text[6]
            getString(R.string.economy)->text[7]
            else -> ""
        }.toString()
    }

    override fun hasOverlappingRendering() = false
}