package anko

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.sportball.R
import org.jetbrains.anko.*

class Item : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        relativeLayout {
            lparams(matchParent, wrapContent)

            imageView {
                id = R.id.itemLogo
                scaleType = ImageView.ScaleType.CENTER_INSIDE
                padding = dip(32)
            }.lparams(matchParent, dip(200))

            textView {
                id = R.id.itemTitle
                textSize = 16F
                padding = dip(8)
                backgroundColor = ContextCompat.getColor(ui.ctx, android.R.color.black)
                textColor = ContextCompat.getColor(ui.ctx, android.R.color.white)
            }.lparams(wrapContent, wrapContent)
        }
    }
}