package com.yasu22go25.twitterclone.controller

import com.yasu22go25.twitterclone.controller.dto.request.PostUserRequestParameter
import com.yasu22go25.twitterclone.controller.dto.response.UserResponse
import com.yasu22go25.twitterclone.domain.model.User
import com.yasu22go25.twitterclone.domain.value.UserId
import com.yasu22go25.twitterclone.usecase.user.dto.PostUserUseCaseDto
import com.yasu22go25.twitterclone.usecase.user.interfaces.PostUserUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/users"])
class UserController(
    val postUserUseCase: PostUserUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody parameters: PostUserRequestParameter): UserResponse {
        val dto = PostUserUseCaseDto(
            screenName = parameters.screenName,
            customUserId = parameters.customUserId,
            createAt = parameters.createAt,
            email = parameters.email,
            birthDay = parameters.birthDay,
            iconUrl = parameters.iconUrl,
            headerUrl = parameters.headerUrl,
            bio = parameters.bio,
            location = parameters.location,
            website = parameters.website,
            isPrivate = parameters.isPrivate
        )

        val domain = postUserUseCase.post(dto)

        return UserResponse(domain)
    }
}