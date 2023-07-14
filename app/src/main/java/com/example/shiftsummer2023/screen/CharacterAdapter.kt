package com.example.shiftsummer2023.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shiftsummer2023.databinding.CharacterItemBinding
import com.example.shiftsummer2023.domain.models.Character
import com.example.shiftsummer2023.formatCharacterGender

class CharacterAdapter :
    PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(CHARACTER_COMPARATOR) {

    class CharacterViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) = with(binding) { // Потом изменю
            name.text = character.name
            gender.text = formatCharacterGender(itemView.context, gender = character.gender)
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
            holder.bind(it)
        }
    }
}

val CHARACTER_COMPARATOR = object : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem == newItem
}
