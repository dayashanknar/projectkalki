@file:Suppress("DEPRECATION")

import android.app.Activity
import android.graphics.Color
import android.view.View

fun Activity.setStatusBarColor(color:Int){
    var flags = window?.decorView?.systemUiVisibility // get current flag
    if (flags != null) {
        if(isColorDark(color)){
            flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            window?.decorView?.systemUiVisibility = flags
        }else{
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window?.decorView?.systemUiVisibility = flags
        }
    }
    window?.statusBarColor = color
    window?.navigationBarColor = color
}

fun Activity.isColorDark(color:Int) : Boolean{
    val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
    return darkness >= 0.5
}


//        activity?.setStatusBarColor(Color.parseColor("#ffffff"))

//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        window.statusBarColor = this.resources.getColor(android.R.color.white)
//        window.navigationBarColor = this.resources.getColor(android.R.color.white);