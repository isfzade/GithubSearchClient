package az.isfan.test3205.data.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource

class HeaderInterceptor: Interceptor {
    private val TAG = "isf_HeaderInterceptor"

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val request: Request = chain.request()
                .newBuilder()
                .build()
            return chain.proceed(request)
        }
        catch (e: Exception) {
            Log.e(TAG, "intercept: error = $e")
            return Response.Builder()
                .code(418)
                .request(chain.request())
                .body(object: ResponseBody() {
                    override fun contentLength() = 0L
                    override fun contentType(): MediaType? = null
                    override fun source(): BufferedSource = Buffer()
                })
                .message(e.message ?: e.toString())
                .protocol(Protocol.HTTP_1_1)
                .build()
        }
    }
}