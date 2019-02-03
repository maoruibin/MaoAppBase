package name.gudong.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/2 - 10:30 AM.
 */
abstract class BaseAdapter<T : IAdapterEntity, VH : RecyclerView.ViewHolder?> : RecyclerView.Adapter<VH>() {
    var mDataList: MutableList<T> = mutableListOf()

    init {
        notifyDataSetChanged()
    }

    val HEAD = 1
    val NORMAL = 2
    val FOOT = 3


    var mFootView: View? = null
    var mHeadView: View? = null

    fun addHeadView(headView: View) {
        this.mHeadView = headView
    }

    fun addFootView(footView: View) {
        this.mFootView = footView
    }

    fun getHeadViewCount(): Int {
        return if (mHeadView == null) 0 else 1
    }

    fun getFootViewCount(): Int {
        return if (mFootView == null) 0 else 1
    }


    override fun getItemCount() = mDataList.size + getHeadViewCount() + getFootViewCount()

    override fun getItemViewType(position: Int): Int {
        if (position < getHeadViewCount()) return HEAD
        if (position >= mDataList.size + getHeadViewCount()) return FOOT
        return NORMAL

    }

    fun fillData(list: List<T>) {
        mDataList.clear()
        for (item in list) {
            mDataList.add(item)
        }
        notifyDataSetChanged()
    }

    fun addItem(position: Int, item: T) {
        mDataList.add(position, item)
        notifyItemInserted(position)
    }

    fun addItem(item: T) {
        mDataList.add(0, item)
        notifyItemInserted(mDataList.indexOf(item))
    }

    fun removeItem(position: Int) {
        mDataList.removeAt(position)
        if (position > 0) {
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        } else {
            notifyDataSetChanged()
        }
    }

    fun removeItem(item: T) {
        val index = mDataList.indexOf(item)
        if (index >= 0) {
            removeItem(index)
        }
    }

    fun updateItem(item: T) {
        val result = mDataList.find { item.entityId() == it.entityId() } ?: return
        val index = mDataList.indexOf(result)
        if (index >= 0) {
            mDataList.removeAt(index)
            mDataList.add(index, item)
            notifyItemChanged(index)
        }
    }

    fun getItem(pos: Int): T {
        return mDataList[pos]
    }

    fun getDataCount(): Int {
        return mDataList.size
    }

}