package com.example.dndmonstersbook.model

data class MonstersModel (
    val count: Number? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<MonstersModel>,
    val languages: String? = null,
    val challenge_rating: String? = null,
    val alignment: String? = null,
    val armor_class: Number? = null,
    val charisma: Number? = null,
    val constitution: Number? = null,
    val dexterity: Number? = null,
    val hit_points: Number? = null,
    val intelligence: Number? = null,
    val name: String? = null,
    val size: String? = null,
    val strength: Number? = null,
    val type: String? = null,
    val wisdom: Number? = null
)