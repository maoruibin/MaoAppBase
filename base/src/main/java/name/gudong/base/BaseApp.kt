package name.gudong.base

import android.app.Application
import com.github.anzewei.parallaxbacklayout.ParallaxHelper
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.https.HttpsUtils
import com.zhy.http.okhttp.log.LoggerInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy



/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/1 - 3:57 PM.
 */
open class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initStetho()
        initLogger()
        initOkHttp()
        initBackLayout()
    }

    private fun initStetho(){
//        Stetho.initializeWithDefaults(this);
    }

    private fun initBackLayout() {
        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance())
    }


    private fun initLogger(){
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
            .methodCount(1)         // (Optional) How many method line to show. Default 2
            .methodOffset(4)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag("MaoApp")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    private fun initOkHttp() {
        val sslParams = HttpsUtils.getSslSocketFactory(null, null, null)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(LoggerInterceptor("GudongApp"))
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//            .addInterceptor(StethoInterceptor())
            .build()
        OkHttpUtils.initClient(okHttpClient)
    }


}