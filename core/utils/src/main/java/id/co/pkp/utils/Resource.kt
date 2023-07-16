package id.co.pkp.utils

/**
 * created by RIZKI RACHMANUDIN on 16/07/2023
 */
sealed class Resource(val data: Any? = null, val message: String? = null) {
    class Success(data: Any?) : Resource(data)
    class Error(message: String?, data: Any? = null) : Resource(data, message)
    class Loading(data: Any? = null) : Resource(data)
}
