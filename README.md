# 一款阅读类App （MVP + RxJava + Retrofit）

* 整体项目基于 MVP + RxJava + Retrofit
* 白天夜间模式切换
* 通过 Retrofit 实现了无网缓存
* 基于 MVP 模式对 Activity 和 Fragment 封装了两个基类，同样适用于非 MVP 的实现。
* 运用 RecyclerView 加载了多种复杂布局
* GitHub 项目地址 : [https://github.com/wlt2017/zhizhihuhu](https://github.com/wlt2017/zhizhihuhu)

#尊重原创
>* 前段时间一直在学习MVP、RxJava、Retrofit，刚好看到简书上的一篇文章：[实践！业余时间做的一款阅读类App （MVP + RxJava + Retrofit）](http://www.jianshu.com/p/be0f4a4863ae?utm_campaign=haruki&utm_content=note&utm_medium=reader_share&utm_source=qq)。于是就下载了源码，自己实现了一遍，并加了些新功能。

####原作者
* GitHub: [Werb](https://github.com/Werb)

####原项目的链接
*  [https://github.com/Werb/GankWithZhihu](https://github.com/Werb/GankWithZhihu)

####再次感谢[Werb](https://github.com/Werb)

##我做了什么
>* 完全理解的作者代码的含义，然后自己实现了一遍。xml除外...
>* 改变了主页面的风格，去除了TAB加入了DrawLayout侧滑
>* 实现了白天/夜间模式

##为什么要写这个APP并且传到GITHUB上来呢？
>* 兴趣、学习和分享
>* 第一条是骗人的，马上要工作了，积累点项目经验
>* 希望以后多使用GITHUB，这是一个开始

### 主界面
* 汇集了知乎日报，干货集中营，以及好奇心日报，三种不同风格的阅读体验
* 知乎日报 API 取自[ZhihuDailyPurify](https://github.com/izzyleung/ZhihuDailyPurify/wiki/%E7%9F%A5%E4%B9%8E%E6%97%A5%E6%8A%A5-API-%E5%88%86%E6%9E%90)
* 干货集中营 API 取自[gank.io](http://gank.io/api)
* 好奇心日报 API 看源码吧
![one](https://raw.githubusercontent.com/wlt2017/zhizhihuhu/master/screenshots/01.png)
![two](https://raw.githubusercontent.com/wlt2017/zhizhihuhu/master/screenshots/02.png)



* 感谢开源项目 [ZhihuDailyPurify](https://github.com/izzyleung/ZhihuDailyPurify/wiki/%E7%9F%A5%E4%B9%8E%E6%97%A5%E6%8A%A5-API-%E5%88%86%E6%9E%90)
* 感谢 [gank.io](http://gank.io/api)
* 感谢 [MeiZhi](https://github.com/drakeet/Meizhi)
* 同时希望可以帮助到其他人
* 项目中用到的 api 所有权归 知乎，gank.io，好奇心日报所有，本项目仅是用来学习使用


### Contact Me
* Email: autumnsassou@163.com
* GitHub: [wlt2017](https://github.com/wlt2017)
![me](https://raw.githubusercontent.com/wlt2017/zhizhihuhu/master/screenshots/me.png)
