package com.rizkir.core.utils

import kotlinx.coroutines.flow.Flow

interface NetworkObserver {
    fun observe(): Flow<Status>

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}