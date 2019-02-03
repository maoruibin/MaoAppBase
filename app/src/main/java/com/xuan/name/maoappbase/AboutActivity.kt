package com.xuan.name.maoappbase

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.github.anzewei.parallaxbacklayout.ParallaxBack
import kotlinx.android.synthetic.main.activity_about.*
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element
import name.gudong.base.BaseActivity

@ParallaxBack
class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        initTitle("关于")
        val versionElement = Element()
        versionElement.title = "version 1.0"

        val demoElement = Element()
        demoElement.title = "体验版介绍"
        demoElement.onClickListener = View.OnClickListener {
            val dialog = AlertDialog.Builder(this).create()
            dialog.setTitle("提示")
            dialog.setMessage("你正在使用的是 Passbook 的体验版，体验版拥有跟正式版一致的功能体验")
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"知道了") { _, _ -> }
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }

        val update = Element()
        update.title = "检查更新"
        update.iconDrawable = R.mipmap.ic_launcher
        update.intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://fir.im/xwyp"))


        val aboutPage = AboutPage(this)

        aboutPage.isRTL(false)

        aboutPage.setImage(R.mipmap.ic_launcher)
        aboutPage.addItem(versionElement)
        aboutPage.addItem(demoElement)


        aboutPage.addGroup("更多信息")
        aboutPage.addEmail("gudong.name@gmail.com", "联系作者")
        aboutPage.addItem(update)
        aboutPage.addWebsite("http://gudong.name/", "个人主页")
        aboutPage.setDescription("个人密码存储管理工具，简单易用 by 咕咚")
        aboutPage.addGitHub("maoruibin")


        fl_container.addView(aboutPage.create())
    }
}
