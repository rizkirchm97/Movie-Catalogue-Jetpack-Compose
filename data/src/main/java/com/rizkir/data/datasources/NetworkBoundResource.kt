//package com.rizkir.data.datasources
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MediatorLiveData
//import com.rizkir.core.utils.Result
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.combine
//import kotlinx.coroutines.flow.firstOrNull
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOn
//import kotlinx.coroutines.flow.launchIn
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
///**
// * created by RIZKI RACHMANUDIN on 20/07/2023
// */
//abstract class NetworkBoundResource<ResultType, RequestType>() {
//    private val scope = CoroutineScope(Dispatchers.IO)
//    private val result = MediatorLiveData<Result<ResultType>>()
//
//    init {
//        result.value = Result.Loading(false)
//        scope.launch {
//            val dbSource = loadFromDB()
//            result.addSource(dbSource) { data ->
//                result.removeSource(dbSource)
//                if (shouldFetch(data)) {
//                    fetchFromNetwork(dbSource)
//                } else {
//                    result.addSource(dbSource) { newData ->
//                        result.value = Result.Success(newData)
//                    }
//                }
//            }
//
////            dbSource.collect { resultType ->
////                when (resultType) {
////                    is Result.Success -> {
////                        if (shouldFetch(resultType.data)) {
////                            fetchFromNetwork(dbSource)
////                        } else {
////                            result.value = Result.Success(resultType.data)
////                        }
////                    }
////
////                    is Result.Error -> {
////                        fetchFromNetwork(dbSource)
////                    }
////
////                    else -> {
////                        fetchFromNetwork(dbSource)
////                    }
////                }
//////                if (shouldFetch(resultType)) {
//////                    fetchFromNetwork(dbSource)
//////                } else {
//////                    result.value = Result.Success(resultType)
//////                }
////            }
//        }
//    }
//
//    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
//        val apiResponse = createCall()
//        result.addSource(dbSource) { newData ->
//            result.value = Result.Loading(false)
//        }
//
//        result.addSource(apiResponse) { response ->
//            result.removeSource(apiResponse)
//            result.removeSource(dbSource)
//            when(response) {
//                is Result.Success -> {
//                    scope.launch {
//                        saveCallResult(response.data)
//                        result.addSource(loadFromDB()) { newData ->
//                            result.value = Result.Success(newData)
//                        }
//                    }
//
//                }
//
//
//                is Result.Error -> {
//                    onFetchFailed()
//                    result.addSource(dbSource) { newData ->
//                        result.value = Result.Error(response.message, newData.hashCode())
//                    }
//                }
//
//
//                else -> Unit
//            }
//        }
//
////        result.addSource(dbSource)
////        try {
////            apiResponse.collect { response ->
////                emit(Result.Loading(false))
////                when (response) {
////                    is Result.Success -> {
////                        saveCallResult(response.data)
//////                        withContext(Dispatchers.Main) {
////                            dbSource.combine(loadFromDB()) { dbData, apiData ->
////                                Result.Success(apiData as Result<ResultType>)
////                            }.collect { resultType ->
////                                result.value = resultType.data as Result<ResultType>
////                            }
//////                        }
////
////                    }
////
////                    is Result.Error -> {
////                        onFetchFailed()
////                        emit(
////                            Result.Error(
////                                message = response.message.toString(),
////                                code = response.code
////                            )
////                        )
////                    }
////
////                    else -> {
//////                        withContext(Dispatchers.Main) {
//////                            dbSource.combine(loadFromDB()) { dbData, apiData ->
//////                                Result.Success(apiData as Result<ResultType>)
//////                            }.collect { resultType ->
//////                                result.value = resultType.data as Result<ResultType>
//////                            }
//////                        }
////                    }
////                }
////            }
////
////        } catch (e: Exception) {
////            emit(Result.Error(message = e.localizedMessage.toString(), code = 0))
////        }
//
//
//    }
//
//    abstract fun loadFromDB(): LiveData<ResultType>
//    abstract suspend fun shouldFetch(data: ResultType?): Boolean
//    abstract fun createCall(): LiveData<Result<RequestType>>
//    abstract fun saveCallResult(data: RequestType)
//    abstract fun onFetchFailed()
//
//    fun asLivedata(): LiveData<Result<ResultType>> = result
//
//}