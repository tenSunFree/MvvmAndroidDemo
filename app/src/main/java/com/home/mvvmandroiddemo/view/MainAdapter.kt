package com.home.mvvmandroiddemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.home.mvvmandroiddemo.R
import com.home.mvvmandroiddemo.model.data.model.DataModel

class MainAdapter :
    ListAdapter<DataModel, MainAdapter.MenuViewHolder>(ForecastDiff) {

    var setOnItemClickListener: ((yy: Int) -> Unit)? = null

    private object ForecastDiff : DiffUtil.ItemCallback<DataModel>() {
        override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_main_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(getItem(position), position, setOnItemClickListener)
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameMaterialTextView: MaterialTextView =
            itemView.findViewById(R.id.material_text_view_name)
        private val introductionMaterialTextView: MaterialTextView =
            itemView.findViewById(R.id.material_text_view_introduction)
        private val rootMaterialCardView: MaterialCardView =
            itemView.findViewById(R.id.material_card_view_root)

        fun bindData(
            data: DataModel,
            position: Int,
            clickItemListener: ((yy: Int) -> Unit)?
        ) {
            data.apply {
                nameMaterialTextView.text = name
                introductionMaterialTextView.text = introduction
                rootMaterialCardView.setOnClickListener {
                    clickItemListener?.invoke(position)
                }
            }
        }
    }
}