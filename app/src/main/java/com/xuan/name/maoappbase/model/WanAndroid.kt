package com.xuan.name.maoappbase.model


import com.google.gson.annotations.SerializedName
import name.gudong.base.IAdapterEntity
import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport

data class DatasItem(@SerializedName("id")
                     @Column(unique = true)
                     val dataId: Long = 0,

                     @SerializedName("title")
                     @Column(nullable = false)
                     val title: String = "",

                     @SerializedName("superChapterName")
                     val superChapterName: String = "",
                     @SerializedName("publishTime")
                     val publishTime: Long = 0,
                     @SerializedName("visible")
                     val visible: Int = 0,
                     @SerializedName("niceDate")
                     val niceDate: String = "",
                     @SerializedName("projectLink")
                     val projectLink: String = "",
                     @SerializedName("author")
                     val author: String = "",
                     @SerializedName("zan")
                     val zan: Int = 0,
                     @SerializedName("origin")
                     val origin: String = "",
                     @SerializedName("chapterName")
                     val chapterName: String = "",
                     @SerializedName("link")
                     val link: String = "",

                     @SerializedName("type")
                     val type: Int = 0,
                     @SerializedName("userId")
                     val userId: Int = 0,
                     @SerializedName("tags")
                     @Column(ignore = true)
                     val tags: List<TagsItem>?,
                     @SerializedName("apkLink")
                     val apkLink: String = "",
                     @SerializedName("envelopePic")
                     val envelopePic: String = "",
                     @SerializedName("chapterId")
                     val chapterId: Int = 0,
                     @SerializedName("superChapterId")
                     val superChapterId: Int = 0,

                     @SerializedName("fresh")
                     val fresh: Boolean = false,
                     @SerializedName("collect")
                     val collect: Boolean = false,
                     @SerializedName("courseId")
                     val courseId: Int = 0,
                     @SerializedName("desc")
                     val desc: String = "") : LitePalSupport(),IAdapterEntity {
    override fun entityId(): Any {
        return dataId
    }
}


data class WanList(@SerializedName("data")
                   val data: Data,
                   @SerializedName("errorCode")
                   val errorCode: Int = 0,
                   @SerializedName("errorMsg")
                   val errorMsg: String = "")


data class TagsItem(@SerializedName("name")
                    val name: String = "",
                    @SerializedName("url")
                    val url: String = "")


data class Data(@SerializedName("over")
                val over: Boolean = false,
                @SerializedName("pageCount")
                val pageCount: Int = 0,
                @SerializedName("total")
                val total: Int = 0,
                @SerializedName("curPage")
                val curPage: Int = 0,
                @SerializedName("offset")
                val offset: Int = 0,
                @SerializedName("size")
                val size: Int = 0,
                @SerializedName("datas")
                val datas: List<DatasItem>?)


