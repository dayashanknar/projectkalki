import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.gamstrain.venjns.R


fun View.slideRight(animTime: Long, startOffsetTime: Long) {
    val slideRight = AnimationUtils.loadAnimation(context, R.anim.slide_right).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffsetTime
    }
    startAnimation(slideRight)
}