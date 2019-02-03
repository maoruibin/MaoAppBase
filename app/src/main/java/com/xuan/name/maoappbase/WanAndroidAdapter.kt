package com.xuan.name.maoappbase

import com.xuan.name.maoappbase.model.DatasItem
import kotlinx.android.synthetic.main.item_wan_android.view.*
import name.gudong.base.BaseListAdapter

/**
 * author  : ruibin1 (ruibin1@staff.weibo.com)
 * create  : 2019/2/2 - 10:40 AM.
 */
class WanAndroidAdapter:BaseListAdapter<DatasItem>() {
    override fun layoutId(): Int {
        return R.layout.item_wan_android
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvTitle.text = getItem(position).title
    }
}