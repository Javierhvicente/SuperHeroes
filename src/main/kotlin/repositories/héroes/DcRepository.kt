package org.example.repositories.héroes

import org.example.models.DcHero
import org.example.repositories.base.CrudRepository
import java.time.LocalDateTime

class DcRepository :CrudRepository<DcHero, Int> {
    private var dcheroes: Array<DcHero?> = arrayOfNulls(10)
    private var key = 0
    override fun getAll(): Array<DcHero?> {
        return dcheroes.filterNotNull().toTypedArray()
    }

    override fun delete(key: Int): DcHero? {
        var hero: DcHero? = null
        this.dcheroes.indexOfFirst { it?.id == key }
            .takeIf { it != -1 }
            ?.let {
                hero = dcheroes[it]
                dcheroes[it] = null
            }. also {
                if(dcheroes.count(){it == null} > 10){
                    dcheroes.filterNotNull().toTypedArray()
                }
            }
        return hero
    }

    override fun update(key: Int, value: DcHero): DcHero? {
        return getById(key)?.apply {
            nombre = value.nombre
            alias = value.alias
            altura = value.altura
            edad = value.edad
            notas = value.notas
            updatedAt = LocalDateTime.now()
        }
    }

    override fun save(value: DcHero): DcHero {
        if(dcheroes.count(){it == null} == 0){
            dcheroes = dcheroes.copyOf(dcheroes.size + 10)
        }
        val index = dcheroes.indexOfFirst { it == null }
        key++
        value.id = key
        value.createdAt = LocalDateTime.now()
        dcheroes[index] = value
        return value
    }

    override fun getById(key: Int): DcHero? {
        return dcheroes.firstOrNull{it?.id == key}
    }
}