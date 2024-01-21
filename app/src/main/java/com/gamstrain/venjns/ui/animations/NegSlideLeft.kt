import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.gamstrain.venjns.R

fun View.NegSlideLeft(animTime: Long, startOffsetTime: Long) {
    val negSlideLeft = AnimationUtils.loadAnimation(context, R.anim.neg_slide_left).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffsetTime
    }
    startAnimation(negSlideLeft)
}