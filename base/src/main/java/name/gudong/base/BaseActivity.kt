package name.gudong.base

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.view.Menu
import android.view.MenuItem

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun initTitle(title:Int){
        initTitle(getString(title))
    }

    fun initTitle(title:String,homeAsUp:Boolean = true){
        supportActionBar?.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(homeAsUp)
        supportActionBar!!.setDisplayShowHomeEnabled(homeAsUp)
    }

    fun initTitleIcon(@DrawableRes resId:Int){
        supportActionBar!!.setHomeAsUpIndicator(resId)
    }

    fun setSubTitle(title: String?){
        supportActionBar?.subtitle = title
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if(menuRes()>0){
            menuInflater.inflate(menuRes(), menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    open fun menuRes(): Int {
        return -1
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> onBackPressed()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
