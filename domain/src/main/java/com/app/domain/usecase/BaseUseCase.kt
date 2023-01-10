package com.app.domain.usecase

abstract class BaseUseCase<Model, Params> {
    abstract suspend fun buildRequest(page: Int): Model
}