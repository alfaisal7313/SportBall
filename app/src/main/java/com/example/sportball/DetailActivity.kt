package com.example.sportball

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import anko.DetailActivityUi
import coil.api.load
import com.example.sportball.model.DataLiga
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class DetailActivity : AppCompatActivity(), AnkoLogger {
    companion object {
        const val DATA_LIGA: String = "data_liga"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUi().setContentView(this@DetailActivity)

        val image = find<ImageView>(R.id.imageDetail)
        val title = find<TextView>(R.id.titleDetail)
        val desc = find<TextView>(R.id.desctiptionDetail)

        intent?.extras?.getParcelable<DataLiga>(DATA_LIGA).let {
            debug("Data : ", Throwable(it?.name))
            it?.logo?.let { value -> image.load(value) }
            title.text = it?.name
            desc.text = it?.dec
        }
    }
}
