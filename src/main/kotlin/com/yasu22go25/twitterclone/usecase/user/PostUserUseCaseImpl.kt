package com.yasu22go25.twitterclone.usecase.user

import com.yasu22go25.twitterclone.domain.model.User
import com.yasu22go25.twitterclone.domain.value.Email
import com.yasu22go25.twitterclone.domain.value.UserId
import com.yasu22go25.twitterclone.infra.repository.interfaces.UserRepository
import com.yasu22go25.twitterclone.usecase.user.dto.PostUserUseCaseDto
import com.yasu22go25.twitterclone.usecase.user.interfaces.PostUserUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PostUserUseCaseImpl(
    val repository: UserRepository
): PostUserUseCase {

    override fun post(dto: PostUserUseCaseDto): User {
        print("post user dto: $dto")

        val domain = User(
            id = UserId(),
            screenName = dto.screenName,
            customUserId = dto.customUserId,
            createAt = dto.createAt,
            email = Email(dto.email),
            birthDay = dto.birthDay,
            iconUrl = dto.iconUrl,
            headerUrl = dto.headerUrl,
            bio = dto.bio,
            location = dto.location,
            website = dto.website,
            isPrivate = dto.isPrivate
        )

        return repository.save(domain)
    }
}