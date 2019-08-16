package com.momot.kotlin.graphQl.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.momot.kotlin.graphQl.entity.Review
import com.momot.kotlin.graphQl.entity.Snack
import com.momot.kotlin.graphQl.repository.SnackRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver( val snackRepository: SnackRepository,
                          private val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun snacks(): List<Snack> {
        val list = snackRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(snackId = item.id)
        }
        return list
    }

    private fun getReviews(snackId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }
}