package com.example.aviatickets.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.aviatickets.model.entity.Offer

class OfferDiffCallback : DiffUtil.ItemCallback<Offer>() {
    override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
        return oldItem.id == newItem.id // замените "id" на уникальный идентификатор элемента Offer
    }

    override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
        return oldItem == newItem
    }
}
