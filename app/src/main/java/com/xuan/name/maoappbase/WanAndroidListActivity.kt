package com.xuan.name.maoappbase

import android.os.Bundle
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.xuan.name.maoappbase.model.DatasItem
import com.xuan.name.maoappbase.model.WanList
import com.zhy.http.okhttp.OkHttpUtils
import name.gudong.base.BaseListActivity
import org.litepal.LitePal

/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/2 - 10:23 AM.
 */
class WanAndroidListActivity:BaseListActivity<DatasItem,WanAndroidAdapter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTitle("玩 Android")
    }


    override fun initAdapter(): WanAndroidAdapter {
        return WanAndroidAdapter()
    }

    override fun emptyMsg(): String {
        return "没有数据，刷新重试"
    }

    override fun fetchListData(): List<DatasItem> {
        val url = "http://wanandroid.com/article/listproject/0/json"
        val response = OkHttpUtils
            .get()
            .url(url)
            .build()
            .execute()

        val responseString = response.body()!!.string()
        val list = Gson().fromJson<WanList>(responseString,
            WanList::class.java)
        val realList = list.data.datas
        realList!!.forEach {
            Logger.d(it.dataId)
            val len = LitePal.where("dataId = ?",""+it.dataId).count(DatasItem::class.java)
            if(len==0){
                it.save()
                Logger.d("第一次插入 ")
            }else{
                Logger.d("已存在")
            }
        }

        return realList
    }




}