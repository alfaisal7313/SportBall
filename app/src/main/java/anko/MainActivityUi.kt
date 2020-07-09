package anko

import android.view.View
import com.example.sportball.MainActivity
import com.example.sportball.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout

/**
 * Generate with Plugin
 * @plugin Kotlin Anko Converter For Xml
 * @version 1.3.4
 */
class MainActivityUi : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        relativeLayout {
            lparams(matchParent, matchParent)
            recyclerView {
                id = R.id.rv_main
                lparams(matchParent, matchParent)
            }
        }
    }
}
