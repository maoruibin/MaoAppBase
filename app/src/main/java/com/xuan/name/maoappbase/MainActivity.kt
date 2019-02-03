package com.xuan.name.maoappbase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.geek.thread.GeekThreadManager
import com.geek.thread.ThreadPriority
import com.geek.thread.ThreadType
import com.geek.thread.task.GeekRunnable
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import name.gudong.base.BaseActivity
import okhttp3.Call
import org.litepal.LitePal


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTitle("Base",false)
        if(AndPermission.hasPermissions(this,Permission.Group.STORAGE)){
            AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE)
                .onGranted {
                    Toast.makeText(this,"授权成功",Toast.LENGTH_LONG).show()

                }
                .onDenied {
                    // Storage permission are not allowed.
                    Toast.makeText(this,"授权失败",Toast.LENGTH_LONG).show()
                }
                .start()
        }else{

        }
    }

    override fun menuRes():Int{
        return R.menu.main
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_setting -> gotoSetting()
            R.id.menu_about -> gotoAbout()
            R.id.menu_test -> startActivity(Intent(this,WanAndroidListActivity::class.java))
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun gotoAbout() {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    private fun gotoSetting() {
        startActivity(Intent(this, SettingActivity::class.java))
    }

}

