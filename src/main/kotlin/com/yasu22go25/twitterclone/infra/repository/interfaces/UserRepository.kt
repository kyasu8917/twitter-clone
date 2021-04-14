package com.yasu22go25.twitterclone.infra.repository.interfaces

import com.yasu22go25.twitterclone.domain.model.User

interface UserRepository {
    fun save(domain: User): User
}