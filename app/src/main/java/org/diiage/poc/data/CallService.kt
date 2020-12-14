package org.diiage.poc.data

import org.json.JSONException
import retrofit2.Call
import java.io.IOException


@Throws(SpecialException::class)
fun <T> genericCall(call : Call<T>) : T?  {
    var message =""
    try {
        call.execute().apply {
            message = this.message()
            if(isSuccessful) {
                return body()
            } else {
                raw().message()
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    message = if (message == "")"Timeout" else message
    throw SpecialException.Timeout(message)
}
