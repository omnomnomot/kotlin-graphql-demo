package com.momot.kotlin.graphQl.repository

import com.momot.kotlin.graphQl.entity.Snack
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SnackRepository : MongoRepository<Snack, String>