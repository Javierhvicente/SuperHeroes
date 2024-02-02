package org.example.repositories.héroes

import org.example.models.MarvelHero
import org.example.repositories.base.CrudRepository

class MarvelRepository: CrudRepository<MarvelHero, Int> {
    private var marvelHeroes: Array<MarvelHero?> = arrayOfNulls<MarvelHero>(10)
    private var key: Int = 1
    override fun getAll(): Array<MarvelHero?> {
        val heroesNoNulos = Array<MarvelHero?>(marvelHeroes.size - contarNulos()){null}
        var index = 0
        for (i in marvelHeroes.indices){
            if(marvelHeroes[i] != null){
                heroesNoNulos[index] = marvelHeroes[i]!!
                index++
            }
        }
        return heroesNoNulos
    }

    private fun contarNulos(): Int {
        var nulos = 0
        for(i in marvelHeroes.indices){
            if(marvelHeroes[i] == null){
                nulos++
            }
        }
        return nulos
    }

    override fun delete(key: Int): MarvelHero? {
        TODO("Not yet implemented")
    }

    override fun update(key: Int, value: MarvelHero): MarvelHero? {
        TODO("Not yet implemented")
    }

    override fun save(value: MarvelHero): MarvelHero {
        TODO("Not yet implemented")
    }

    override fun getById(key: Int): MarvelHero? {
        TODO("Not yet implemented")
    }
}