import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.gamstrain.venjns.R


fun View.slideBottom(animTime: Long, startOffsetTime: Long) {
    val slideBottom = AnimationUtils.loadAnimation(context, R.anim.slide_bottom).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffsetTime
    }
    startAnimation(slideBottom)
}