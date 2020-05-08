package ru.gidline.app.screen.main.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.gidline.app.R

class DetailPurchaseFragment : Fragment() {

    companion object {
         fun newInstance( data:String?,price:String?,action:String?): DetailPurchaseFragment {
             val bundle = Bundle()
             bundle.putString("textData",data)
             bundle.putString("textPrice",price)
             bundle.putString("textAction",action)
             val nds =  price?.toFloat()
             nds?.times(0.2)?.let { bundle.putDouble("nds", it) }
             val fragment =
                 DetailPurchaseFragment()
             fragment.arguments=bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_detail_purchase,container,false)
        val workUntil:TextView = view.findViewById(R.id.valid_until)
        val textData:TextView = view.findViewById(R.id.valid_until_name)
        val textPrice:TextView = view.findViewById(R.id.order_cost_name)
        val textNds:TextView = view.findViewById(R.id.nds_order_name)
        val btnTextService:TextView = view.findViewById(R.id.btn_newslatter)
        workUntil.setText(arguments?.get("textData").toString().dropLast(10))
        textData.setText(arguments?.get("textData").toString().drop(12))
        textPrice.setText(arguments?.get("textPrice").toString())
        textPrice.append(" "+getString(R.string.rubl))
        textNds.setText(arguments?.get("nds").toString().dropLast(13))
        textNds.append(" "+getString(R.string.rubl))
        btnTextService.setText(arguments?.get("textAction").toString())

        return view
    }

}
