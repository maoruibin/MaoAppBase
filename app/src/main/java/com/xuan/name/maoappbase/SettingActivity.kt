package com.xuan.name.maoappbase

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.github.anzewei.parallaxbacklayout.ParallaxBack
import name.gudong.base.BaseActivity

@ParallaxBack
class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .commit()

        initTitle("设置")
    }
}

class SettingsFragment: PreferenceFragmentCompat(){
    override fun onCreatePreferences(p0: Bundle?, p1: String?) {
        addPreferencesFromResource(R.xml.main_setting)
    }

}
