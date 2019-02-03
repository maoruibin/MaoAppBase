package name.gudong.base

import com.google.gson.Gson
import com.zhy.http.okhttp.callback.Callback
import okhttp3.Response
import java.io.IOException


/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/1 - 5:42 PM.
 */

inline fun <reified T : Any>T.logTag() = T::class.java

abstract class DataParseCallback<T:Any> : Callback<T>() {
    @Throws(IOException::class)
    fun parseNetworkResponse(response: Response): T {
        val string = response.body()!!.string()
        return Gson().fromJson<T>(string, logTag())
    }
}
