import android.view.View
import android.view.animation.AnimationUtils
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.gamstrain.venjns.R


fun View.negSlideRight(animTime: Long, startOffsetTime: Long) {
    val negSlideRight = AnimationUtils.loadAnimation(context, R.anim.neg_slide_right).apply {
        duration = animTime
        interpolator = FastOutSlowInInterpolator()
        this.startOffset = startOffsetTime
    }
    startAnimation(negSlideRight)
}