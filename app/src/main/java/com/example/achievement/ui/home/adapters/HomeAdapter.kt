package com.example.achievement.ui.home.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.achievement.data.model.AchievementResponseModel
import com.example.achievement.data.model.RecordResponseModel
import com.example.achievement.databinding.RowPersonalRecordBinding
import com.example.achievement.databinding.RowPersonalRecordInternalBinding

class HomeAdapter(private val achievements : List<AchievementResponseModel>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: RowPersonalRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: AchievementResponseModel) {
            binding.achieveModel = model
            binding.rvPersonalRecordInternal.adapter = RecordAdapter(model.records)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding=
            RowPersonalRecordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return HomeViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(achievements[position])
    }

    override fun getItemCount() = achievements.size

}