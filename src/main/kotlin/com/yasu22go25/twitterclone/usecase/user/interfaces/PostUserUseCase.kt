package com.yasu22go25.twitterclone.usecase.user.interfaces

import com.yasu22go25.twitterclone.domain.model.User
import com.yasu22go25.twitterclone.usecase.user.dto.PostUserUseCaseDto

interface PostUserUseCase {
    fun post(user: PostUserUseCaseDto): User
}