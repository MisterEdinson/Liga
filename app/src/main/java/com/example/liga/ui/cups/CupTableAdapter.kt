package com.example.liga.ui.cups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.liga.R
import com.example.liga.data.local.models.LeagueChampGsonModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_cup_table.view.*
import kotlinx.android.synthetic.main.item_league_table.view.*

class CupTableAdapter : RecyclerView.Adapter<CupTableAdapter.CupViewHolder>() {
    class CupViewHolder(view: View) : RecyclerView.ViewHolder(view)

    val callback = object : DiffUtil.ItemCallback<LeagueChampGsonModel>() {
        override fun areItemsTheSame(
            oldItem: LeagueChampGsonModel,
            newItem: LeagueChampGsonModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LeagueChampGsonModel,
            newItem: LeagueChampGsonModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CupViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cup_table, parent, false)
        return CupViewHolder(view)
    }

    override fun onBindViewHolder(holder: CupViewHolder, position: Int) {
        val item = list.currentList[position]

        val gson = Gson()
        val stringTable = item.table
        val objectTableArray = gson.fromJson(stringTable, Array<TableItem>::class.java)
        val objectTableList = objectTableArray.toList()

        holder.itemView.apply {
            tvGroupTable.text = item.standingsGroup

            for (tableItem in objectTableList) {
                //инициализация
                val tvPosition = TextView(context)
                val imgTeam = ImageView(context)
                val teamName = TextView(context)
                //параметры
                val paramText = LinearLayout.LayoutParams(
                    20,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val paramImage = LinearLayout.LayoutParams(
                    30,
                    30
                )
                val paramName = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                //присоединение параметров
                tvPosition.layoutParams = paramText
                imgTeam.layoutParams = paramImage
                teamName.layoutParams = paramName
                //значения
                tvPosition.text = "1"
                imgTeam.loadImage(tableItem.team?.crest.toString())
                teamName.text = tableItem.team?.name
                //присоединение к макету
                linearLayoutTableCup.addView(tvPosition)
                linearLayoutTableCup.addView(imgTeam)
//                val position = tableItem.position.toString()
//                val name = tableItem.team?.name
//                val crest = tableItem.team?.crest.toString()
//                val points = tableItem.points.toString()

                // Создать новые TextView, ImageView или другие представления для каждого элемента списка
//                val tvPosition = TextView(context)
//                val tvName = TextView(context)
//                val imgTeam = ImageView(context)
//                val tvPoints = TextView(context)
//
//                val layoutParams = LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT
//                )
//                val imageParam = LinearLayout.LayoutParams(30,30)
//                layoutParams.setMargins(16, 16, 16, 16)
//                tvName.layoutParams = layoutParams
//                imgTeam.layoutParams = imageParam
//                // Установить значения для созданных представлений
//                tvPosition.text = position
//                tvName.text = name
//                imgTeam.loadImage(crest)
//                tvPoints.text = points
                // Добавляем TextView и ImageView в holder.itemView
//                linearLayoutTableCup.addView(tvName)
//                linearLayoutTableCup.addView(imgTeam)
                // Добавить созданные представления в вашу макетную иерархию
                // Например, добавить в LinearLayout или другой контейнер

//                linearLayoutTableCup.addView(tvPosition)
//                linearLayoutTableCup.addView(tvName)
//                linearLayoutTableCup.addView(imgTeam)
//                linearLayoutTableCup.addView(tvPoints)
            }
//            objectTableList.forEach {
//                tvPositionTeamTable.text = it.position.toString()
//                tvNameTeamTable.text = it.team?.name
//                imgTeamTable.loadImage(it.team?.crest.toString())
//                tvPointTeamTable.text = it.points.toString()
//            }
        }
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    private fun ImageView.loadImage(imgUrl: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadImage.context)) }
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .placeholder(R.drawable.no_image)
            .error(R.drawable.error)
            .data(imgUrl)
            .target(this)
            .build()
        imageLoader.enqueue(request)
    }
}