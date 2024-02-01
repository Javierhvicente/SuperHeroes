package org.example.repositories.héroes

import org.example.models.HéroeMarvel
import org.example.repositories.base.CrudRepository

class MarvelRepository: CrudRepository<HéroeMarvel, Int> {
    private var marvelHeroes: Array<HéroeMarvel?> = arrayOfNulls<HéroeMarvel>(10)
    private var key: Int = 1
    override fun getAll(): Array<HéroeMarvel?> {
        val heroesNoNulos = Array<HéroeMarvel?>(marvelHeroes.size - contarNulos()){null}
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

    override fun delete(key: Int): HéroeMarvel? {
        TODO("Not yet implemented")
    }

    override fun update(key: Int, value: HéroeMarvel): HéroeMarvel? {
        TODO("Not yet implemented")
    }

    override fun save(value: HéroeMarvel): HéroeMarvel {
        TODO("Not yet implemented")
    }

    override fun getById(key: Int): HéroeMarvel? {
        TODO("Not yet implemented")
    }
}