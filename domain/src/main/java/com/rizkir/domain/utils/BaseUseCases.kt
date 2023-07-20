package com.rizkir.domain.utils

import androidx.paging.PagingData
import com.rizkir.core.utils.Result
import kotlinx.coroutines.flow.Flow

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
interface UseCase

interface BaseUseCases<Params, Type : Any> : UseCase {
    suspend fun execute(params: Params?): Flow<Result<Type>>
}