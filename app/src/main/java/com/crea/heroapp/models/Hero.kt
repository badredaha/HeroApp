package com.crea.heroapp.models

class Hero {

    var id: Long? = null
    var name: String? = null
    var power: String? = null
    var url: String? = null


    constructor()

    constructor(id: Long?, name: String, power: String) {
        this.id = id
        this.name = name
        this.power = power
    }

}
