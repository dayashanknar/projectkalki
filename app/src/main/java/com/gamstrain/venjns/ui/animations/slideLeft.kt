import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.gamstrain.venjns.R


fun View.slideLeft(animTime: Long, startOffsetTime: Long) {
    val slideLeft = AnimationUtils.loadAnimation(context, R.anim.slide_left).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffsetTime
    }
    startAnimation(slideLeft)
}