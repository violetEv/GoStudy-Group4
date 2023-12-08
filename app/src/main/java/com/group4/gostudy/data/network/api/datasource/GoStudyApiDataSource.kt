package com.group4.gostudy.data.network.api.datasource

import com.group4.gostudy.data.network.api.model.history.HistoriesResponse
import com.group4.gostudy.data.network.api.model.login.LoginRequest
import com.group4.gostudy.data.network.api.model.login.LoginResponse
import com.group4.gostudy.data.network.api.model.notifcation.NotificationsResponse
import com.group4.gostudy.data.network.api.model.user.UsersResponse
import com.group4.gostudy.data.network.api.model.user.updatepassword.UpdatePasswordRequest
import com.group4.gostudy.data.network.api.model.user.updatepassword.UpdatePasswordResponse
import com.group4.gostudy.data.network.api.model.user.updateuser.UpdateUsersResponse
import com.group4.gostudy.data.network.api.service.GoStudyApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Part

/*
Hi, Code Enthusiast!
https://github.com/yudiatmoko
*/

interface GoStudyApiDataSource {
    suspend fun getNotifications(): NotificationsResponse

    suspend fun getProfile(): UsersResponse

    suspend fun updateProfile(
        name: RequestBody,
        phoneNumber: RequestBody,
        country: RequestBody,
        city: RequestBody,
        image: MultipartBody.Part
    ): UpdateUsersResponse

    suspend fun updatePassword(
        updatePasswordRequest: UpdatePasswordRequest
    ): UpdatePasswordResponse

    suspend fun getHistories(): HistoriesResponse

    suspend fun login(loginRequest: LoginRequest): LoginResponse
}

class GoStudyApiDataSourceImpl(
    private val service: GoStudyApiService
) : GoStudyApiDataSource {
    override suspend fun getNotifications(): NotificationsResponse {
        return service.getNotifications()
    }

    override suspend fun getProfile(): UsersResponse {
        return service.getProfile()
    }

    override suspend fun updateProfile(
        name: RequestBody,
        phoneNumber: RequestBody,
        country: RequestBody,
        city: RequestBody,
        image: MultipartBody.Part
    ): UpdateUsersResponse {
        return service.updateProfile(
            name,
            phoneNumber,
            country,
            city,
            image
        )
    }

    override suspend fun updatePassword(
        updatePasswordRequest: UpdatePasswordRequest
    ): UpdatePasswordResponse {
        return service.updatePassword(
            updatePasswordRequest
        )
    }

    override suspend fun getHistories(): HistoriesResponse {
        return service.getHistories()
    }

    override suspend fun login(
        loginRequest: LoginRequest
    ): LoginResponse {
        return service.login(loginRequest)
    }
}
