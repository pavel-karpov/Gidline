@file:Suppress("unused")

package ru.gidline.app.extension

import android.os.Build
import android.os.Looper
import java.util.*

val offsetTime
    get() = TimeZone.getDefault().getOffset(localTime)

val utcTime
    get() = localTime - offsetTime

val localTime
    get() = System.currentTimeMillis()

val isUiThread: Boolean
    get() = Looper.myLooper() == Looper.getMainLooper()

fun isKitkat() = Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT

fun isKitkatWatch() = Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT_WATCH

fun isLollipop() = Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP

fun isLollipopMR1() = Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1

fun isMarshmallow() = Build.VERSION.SDK_INT == Build.VERSION_CODES.M

fun isNougat() = Build.VERSION.SDK_INT == Build.VERSION_CODES.N

fun isNougatMR1() = Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1

fun isOreo() = Build.VERSION.SDK_INT == Build.VERSION_CODES.O

fun isOreoMR1() = Build.VERSION.SDK_INT == Build.VERSION_CODES.O_MR1

fun isPie() = Build.VERSION.SDK_INT == Build.VERSION_CODES.P

fun isKitkatPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT

fun isKitkatWatchPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH

fun isLollipopPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP

fun isLollipopMR1Plus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1

fun isMarshmallowPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

fun isNougatPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

fun isNougatMR1Plus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1

fun isOreoPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

fun isOreoMR1Plus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1

fun isPiePlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P