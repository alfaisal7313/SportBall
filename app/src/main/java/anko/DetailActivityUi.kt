package anko

import android.graphics.Typeface
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.sportball.DetailActivity
import com.example.sportball.R
import org.jetbrains.anko.*

class DetailActivityUi : AnkoComponent<DetailActivity> {

    override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)

            imageView {
                id = R.id.imageDetail
                padding = dip(16)
                scaleType = ImageView.ScaleType.FIT_XY
            }.lparams(matchParent, dip(200))

            verticalLayout {
                lparams(matchParent, matchParent)
                padding = dip(24)

                textView {
                    id = R.id.titleDetail
                    textSize = 22F
                    hint = "Title"
                    textColor = ContextCompat.getColor(ui.ctx, android.R.color.black)
                    maxLines = 1
                    setTypeface(null, Typeface.BOLD)
                    bottomPadding = dip(8)
                }.lparams(matchParent, wrapContent)

                textView {
                    id = R.id.desctiptionDetail
                    textSize = 16F
                    hint = "Description"
                    movementMethod = ScrollingMovementMethod()
                    textColor = ContextCompat.getColor(ui.ctx, android.R.color.black)
                }.lparams(matchParent, wrapContent)
            }
        }

    }
}