package com.xuan.name.maoappbase

import name.gudong.base.BaseApp
import org.litepal.LitePal

/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/1 - 3:56 PM.
 */
class MainApp: BaseApp() {
    override fun onCreate() {
        initLitePal()
        super.onCreate()
    }

    private fun initLitePal() {
        LitePal.initialize(this)
    }
}