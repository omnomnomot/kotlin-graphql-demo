package com.momot.kotlin.graphQl.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.momot.kotlin.graphQl.entity.Snack
import com.momot.kotlin.graphQl.repository.SnackRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component
import java.util.*

@Component
class SnackMutationResolver(val snackRepository: SnackRepository,
                            private val mongoOperations: MongoOperations) : GraphQLMutationResolver {

    fun newSnack(name: String, amount: Float): Snack {
        val snack = Snack(name, amount)
        snack.id = UUID.randomUUID().toString()
        snackRepository.save(snack)
        return snack
    }

    fun deleteSnack(id: String): Boolean {
        snackRepository.deleteById(id)
        return true
    }

    fun updateSnack(id: String, amount: Float): Snack {
        val snack = snackRepository.findById(id)
        snack.ifPresent {
            it.amount = amount
            snackRepository.save(it)
        }
        return snack.get()
    }
}