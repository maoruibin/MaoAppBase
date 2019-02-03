package name.gudong.base

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.AsyncTask
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import cz.kinst.jakub.view.StatefulLayout
import kotlinx.android.synthetic.main.base_empty.*
import kotlinx.android.synthetic.main.base_list.*

/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/2 - 10:22 AM.
 */
abstract class BaseListActivity<T:IAdapterEntity, out A:BaseListAdapter<T>> : BaseActivity() {
    private val stateEmpty:String = "empty"
    private val stateProgress:String = "progress"
    private var mAdapter: BaseListAdapter<T>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_list)
        initStateLayout()
        initSwipeLayout()

        rv_list.itemAnimator = DefaultItemAnimator()
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ColorDrawable(resources.getColor(dividerColor(),theme)))
        rv_list.addItemDecoration(divider)

        mAdapter = initAdapter()
        rv_list.adapter = mAdapter

        fetchData()
    }

    abstract fun initAdapter():A

    @ColorRes
    open fun dividerColor():Int {
        return R.color.colorDivider
    }


    private fun initStateLayout() {
        stateLayout.setStateView(stateEmpty,LayoutInflater.from(this).inflate(R.layout.base_empty,null))
        stateLayout.setStateView(stateProgress,LayoutInflater.from(this).inflate(R.layout.base_progress,null))
    }

    private fun initSwipeLayout() {
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        swipeLayout.setDistanceToTriggerSync(300)
        //设置下拉刷新的监听
        swipeLayout.setOnRefreshListener {
            swipeLayout.isRefreshing = false
            fetchData()
        }
    }

    fun refillListView(list:List<T>){
        mAdapter!!.fillData(list)
        if (list.isEmpty() && isAutoCheckEmpty()) {
            stateLayout.state = stateEmpty
            tvEmpty.text = emptyMsg()
            btAction.text = emptyActionText()
        } else {
            stateLayout.state = StatefulLayout.State.CONTENT
        }
    }

    abstract fun emptyMsg():String

    /**
     * 数据为空时的提示操作
     */
    open fun emptyActionText(): CharSequence?{
        return ""
    }


    /**
     * 是否自动检测数据列表为空，并提示消息
     */
    open fun isAutoCheckEmpty():Boolean{
        return true
    }

    @SuppressLint("StaticFieldLeak")
    fun fetchData(){
        object : AsyncTask<Void, Void, List<T>>(){
            override fun onPreExecute() {
                super.onPreExecute()
                //列表为空时加载显示进度条
                if(mAdapter!!.itemCount == 0){
                    stateLayout.state = stateProgress
                }
            }

            override fun onPostExecute(result: List<T>?) {
                super.onPostExecute(result)
                if (result != null) {
                    refillListView(result)
                }
            }
            override fun doInBackground(vararg params: Void?): List<T> {
                return fetchListData()
            }
        }.execute()
    }



    abstract fun fetchListData(): List<T>
}