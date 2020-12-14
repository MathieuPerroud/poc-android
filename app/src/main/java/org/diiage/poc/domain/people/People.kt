package org.diiage.poc.domain.people

import org.diiage.poc.domain.starship.Starship

open class People(
    val name: String = "",
    val height: Long = 0,
    val starships: List<Starship> = emptyList()
)