package com.momot.kotlin.graphQl.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.momot.kotlin.graphQl.entity.Review
import com.momot.kotlin.graphQl.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewMutationResolver (private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text:String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}