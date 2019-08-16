package com.momot.kotlin.graphQl.repository

import com.momot.kotlin.graphQl.entity.Review
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : MongoRepository<Review, String>