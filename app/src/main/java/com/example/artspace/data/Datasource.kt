package com.example.artspace.data

import com.example.artspace.R
import com.example.artspace.model.Artspace


class Datasource() {
    fun loadArtspace(): List<Artspace> {
        return listOf<Artspace>(
            Artspace(R.string.art1,R.string.art1_year, R.drawable.art1),
            Artspace(R.string.art2,R.string.art2_year, R.drawable.art2),
            Artspace(R.string.art3,R.string.art3_year, R.drawable.art3),
            Artspace(R.string.art4,R.string.art4_year, R.drawable.art4),)

    }
}
