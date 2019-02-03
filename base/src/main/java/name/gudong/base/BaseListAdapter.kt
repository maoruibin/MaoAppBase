package name.gudong.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/2 - 10:36 AM.
 */
abstract class BaseListAdapter<T : IAdapterEntity> : BaseAdapter<T, BaseListAdapter.ViewHolder>() {
    private var mAdapterClick: BaseListAdapter.IAdapterClick<T>? = null
    abstract fun layoutId():Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListAdapter.ViewHolder {
        if (viewType == HEAD && mHeadView != null) return ViewHolder(mHeadView!!)
        if (viewType == FOOT && mFootView != null) return ViewHolder(mFootView!!)

        val view = LayoutInflater.from(parent.context).inflate(layoutId(), null, false)
        return BaseListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == HEAD) return
        if (getItemViewType(position) == FOOT) return

        val item: T = mDataList[position]

        holder.itemView.setOnClickListener {
            if (mAdapterClick != null) {
                mAdapterClick!!.onClickItem(position, item)
            }
        }
    }

    interface IAdapterClick<in E> {
        /**
         * id : menu 对应的 item id
         * position : 对应的 list position
         * entity : 对应的数据实体
         */
        fun onClickMenuItem(id: Int, position: Int, item: E)

        fun onClickItem(position: Int, item: E)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}