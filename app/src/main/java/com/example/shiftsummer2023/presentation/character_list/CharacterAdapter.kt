package com.example.shiftsummer2023.presentation.character_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shiftsummer2023.databinding.CharacterItemBinding
import com.example.shiftsummer2023.domain.model.Character

class CharacterAdapter(private val characterClickListener: () -> Unit) :
    PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(CHARACTER_COMPARATOR) {

    class CharacterViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character, characterClickListener: () -> Unit) = with(binding) { // Потом изменю
            characterPhoto.load(character.image)
            itemView.setOnClickListener { characterClickListener }
        }
    }

    var characterList: PagingData<Character> = PagingData.empty()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it, characterClickListener)
        }
    }
}

val CHARACTER_COMPARATOR = object : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem == newItem
}
