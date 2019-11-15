package com.crea.heroapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Hero {

    @PrimaryKey
    var id: Long? = null
    @ColumnInfo(name = "name")
    var name: String? = null
    @ColumnInfo(name = "power")
    var power: String? = null
    @ColumnInfo(name = "url")
    var url: String? = null

}
