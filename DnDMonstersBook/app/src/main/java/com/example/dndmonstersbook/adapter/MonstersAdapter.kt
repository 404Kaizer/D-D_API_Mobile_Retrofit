package com.example.dndmonstersbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dndmonstersbook.R
import com.example.dndmonstersbook.model.MonstersModel
import kotlinx.android.synthetic.main.adapter_monsters.view.*

class MonstersAdapter(private val monstersList : List<MonstersModel>)
    : RecyclerView.Adapter<MonstersAdapter.MonstersViewHolder>(){

    class MonstersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindMonsters(monsters: MonstersModel) {
            itemView.monster_name.text = monsters.name
            itemView.monster_size.text = "Size: " + monsters.size
            itemView.monster_dc.text = "DC " + monsters.challenge_rating
            itemView.monster_type.text = "(" + monsters.type + ")"
            itemView.monster_ac.text = "AC " + monsters.armor_class
            itemView.monster_hp.text = "HP " + monsters.hit_points
            itemView.monster_str.text = "STR " + monsters.strength
            itemView.monster_dex.text = "DEX " + monsters.dexterity
            itemView.monster_con.text = "CON " + monsters.constitution
            itemView.monster_intel.text = "INT " + monsters.intelligence
            itemView.monster_wis.text = "WIS " + monsters.wisdom
            itemView.monster_cha.text = "CHA " + monsters.challenge_rating
            itemView.monster_align.text = "Alignment: " + monsters.alignment
            itemView.monster_lang.text = "Languages: " + monsters.languages
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonstersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_monsters, parent, false)
        return MonstersViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonstersViewHolder, position: Int) {
        holder.bindMonsters(monstersList[position])
    }

    override fun getItemCount(): Int {
        return monstersList.size
    }
}