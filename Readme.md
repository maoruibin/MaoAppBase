# AppBase

[![](https://jitpack.io/v/maoruibin/MaoAppBase.svg)](https://jitpack.io/#maoruibin/MaoAppBase)

基础开发框架

## base 基本功能
* 网络请求 1
* 数据存储 1
* 事件通信
* 异步框架 1
* 日志框架 1
* 权限申请 1
* list 页面 1
* 图片加载
* 关于页面 1
* 设置页面 1
* 基础开发框架 1
* 数据统计
* 通用 Util
* UI
  * 通用对话框封装
  * Toast 封装
  * 侧滑返回 1


### 网络请求
* [OkHttp](https://github.com/square/okhttp)
* [OkHttpUtils](https://github.com/hongyangAndroid/okhttputils)
* [gson](https://github.com/google/gson)

### 数据存储
本地SP
*[tray](https://github.com/grandcentrix/tray)
本地数据库
*[LitePal](https://github.com/LitePalFramework/LitePal)

### 日志框架
[logger](https://github.com/orhanobut/logger)

### 异步框架
[GeekThread](https://github.com/OnlyTerminator/GeekThread)

### UI
#### 侧滑返回
* [ParallaxBackLayout](https://github.com/anzewei/ParallaxBackLayout)


## 问题解决

* Android P(9.0) http网络请求的问题
> 为保证 Android P 安全问题，Google 不需要在 Android P 上使用 http,必须使用 https，这里可进行手动关闭操作
https://www.jianshu.com/p/57047a84e559


## Install
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```gradle
dependencies {
        implementation 'com.github.maoruibin:MaoAppBase:0.0.1'
}
```
