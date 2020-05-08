package ru.gidline.app.local.model

data class Purchases(
    val imageId:Int,
    val textAction:String,
    val textData:String,
    val imageAction: Int?,
    val textPrice:String,
    val textPurchase:String
    )