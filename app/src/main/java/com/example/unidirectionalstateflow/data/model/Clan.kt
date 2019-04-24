package com.example.unidirectionalstateflow.data.model

data class Clan(val id: Long, val name: String) {

    companion object {
        fun ranDomClan(): Clan = Clan(Math.round(Math.random()), "")
    }
}