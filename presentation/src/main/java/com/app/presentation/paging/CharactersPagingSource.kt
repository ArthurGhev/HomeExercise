package com.app.presentation.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.common.Mapper
import com.app.domain.entity.CharacterEntityModel
import com.app.domain.usecase.GetCharactersUseCase
import com.app.presentation.model.CharacterUiModel

class CharactersPagingSource(
    private val getUsersUseCase: GetCharactersUseCase,
    private val mapper: Mapper<CharacterEntityModel, CharacterUiModel>
) : PagingSource<Int, CharacterUiModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterUiModel> {
        return try {
            val currentPage = params.key ?: 1
            val response = getUsersUseCase.buildRequest(if (currentPage == 1) 0 else currentPage)
            val responseData = mutableListOf<CharacterUiModel>()
            responseData.addAll(mapper.fromList(response))
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterUiModel>): Int? {
        return null
    }
}