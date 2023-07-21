package com.rizkir.data.datasources

import com.rizkir.data.datasources.local.LocalDataSource

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
interface BaseDataSource<T> {
    suspend fun execute(dataType: DataSourceType): T
}

open class DataSourceImpl<T>(
    private val localDataSource: BaseDataSource<T>,
    private val remoteDataSource: BaseDataSource<T>
) : BaseDataSource<T> {
    override suspend fun execute(dataType: DataSourceType): T {
        return when (dataType) {
            DataSourceType.LOCAL -> localDataSource.execute(dataType)
            DataSourceType.REMOTE -> remoteDataSource.execute(dataType)
        }
    }
}

enum class DataSourceType {
    LOCAL,
    REMOTE
}