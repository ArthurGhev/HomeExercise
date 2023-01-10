package com.app.homeexerciseapp.ui.recyclerview


import com.bumptech.glide.Glide
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.homeexerciseapp.databinding.ListItemCharacterBinding
import com.app.presentation.model.CharacterUiModel
import javax.inject.Inject

class CharactersAdapter @Inject constructor() :
    PagingDataAdapter<CharacterUiModel, CharactersAdapter.ViewHolder>(differCallback) {

    private lateinit var binding: ListItemCharacterBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ListItemCharacterBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterUiModel) = with(binding){
            txtNameValue.text = character.name
            txtSpeciesValue.text = character.species
            txtGenderValue.text = character.gender
//            Glide.with(itemView)
//                .load(user.avatar_url)
//                .centerCrop()
//                .circleCrop()
//                .into(imgAvatar)

            clUser.setOnClickListener {
                onItemClickListener?.invoke(character)
            }
        }
    }

    private var onItemClickListener: ((CharacterUiModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (CharacterUiModel) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        val differCallback = object : DiffUtil.ItemCallback<CharacterUiModel>() {
            override fun areItemsTheSame(oldItem: CharacterUiModel, newItem: CharacterUiModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterUiModel, newItem: CharacterUiModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}