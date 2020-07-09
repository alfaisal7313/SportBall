package com.example.sportball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import anko.MainActivityUi
import com.example.sportball.adapter.Liga
import com.example.sportball.model.DataLiga
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUi().setContentView(this@MainActivity)

        val rv_main = find<RecyclerView>(R.id.rv_main)

        val id = resources.getIntArray(R.array.teamId)
        val name = resources.getStringArray(R.array.teamName)
        val logo = resources.obtainTypedArray(R.array.teamImage)
        val desc = resources.getStringArray(R.array.teamDesc)

        val dataList = mutableListOf<DataLiga>()

        dataList.clear()

        for (i in name.indices) {
            dataList.add(DataLiga(id.get(i), name.get(i), desc.get(i), logo.getResourceId(i, 0)))
        }
        debug("Data: ", Throwable(dataList.toString()))

        rv_main.apply {
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.HORIZONTAL
                )
            )
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = Liga(dataList) { dataLiga: DataLiga ->
                indeterminateProgressDialog("Hello! Please wait...").show()
                startActivity(intentFor<DetailActivity>(DetailActivity.DATA_LIGA to dataLiga))
            }
        }
    }
}
