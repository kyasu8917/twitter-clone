package com.yasu22go25.twitterclone.infra.repository

import com.yasu22go25.twitterclone.domain.model.User
import com.yasu22go25.twitterclone.infra.repository.interfaces.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl: UserRepository {
    override fun save(domain: User): User {
        print("save user: $domain")
        return domain
    }
}