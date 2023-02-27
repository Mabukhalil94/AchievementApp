package com.example.achievement.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.achievement.data.model.RecordResponseModel
import com.example.achievement.databinding.RowPersonalRecordBinding
import com.example.achievement.databinding.RowPersonalRecordInternalBinding

class RecordAdapter(private val records: List<RecordResponseModel>) :
    RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {

    inner class RecordViewHolder(private val binding: RowPersonalRecordInternalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecordResponseModel) {
            binding.recordModel=item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val binding=
            RowPersonalRecordInternalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RecordViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(records[position])
    }

    override fun getItemCount()=records.size


}