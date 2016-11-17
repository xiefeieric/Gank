package uk.me.feixie.gank.data.remote;

import java.util.List;

/**
 * Created by Fei on 17/11/2016.
 */

public class ModelToday {


    /**
     * category : ["Android","休息视频","福利","iOS"]
     * error : false
     * results : {"Android":[{"_id":"5829b5b2421aa911e32d87e3","createdAt":"2016-11-14T21:01:38.860Z","desc":"动画插值器的编辑器","images":["http://img.gank.io/fa3bb06d-1bfb-41a7-8bfe-78adeb55c049"],"publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"Android","url":"https://github.com/MartinRGB/RapidInterpolator","used":true,"who":"Jason"},{"_id":"582bb5f6421aa93a61577f2d","createdAt":"2016-11-16T09:27:18.173Z","desc":"Android MP3录制，波形显示，音频权限兼容与播放","images":["http://img.gank.io/b740d072-3c32-4c8f-aa7a-b0dd45968e19"],"publishedAt":"2016-11-16T11:37:18.947Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/2448e2903b07","used":true,"who":"Shuyu Guo"},{"_id":"582bc15e421aa93a518777ac","createdAt":"2016-11-16T10:15:58.132Z","desc":"一行代码完成图片高斯模糊","images":["http://img.gank.io/d9a60d1c-714d-4bf7-8de9-0b6601b1c110"],"publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"Android","url":"https://github.com/jrvansuita/GaussianBlur","used":true,"who":"代码家"},{"_id":"582bc1b4421aa93a61577f2f","createdAt":"2016-11-16T10:17:24.383Z","desc":"Android 画板 View，随心所欲的画画。","images":["http://img.gank.io/fc1b996a-228c-4553-8cb5-159c046a4531"],"publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"Android","url":"https://github.com/ByoxCode/DrawView","used":true,"who":"代码家"}],"iOS":[{"_id":"582bc2fa421aa93a555cfe90","createdAt":"2016-11-16T10:22:50.604Z","desc":"用 Touchbar 玩儿空战游戏！","images":["http://img.gank.io/99ed5540-08cf-4668-890e-37fc2c08922b","http://img.gank.io/332264cd-8f9c-4191-9c96-e69e5ac01b88"],"publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"iOS","url":"https://github.com/insidegui/TouchBarSpaceFight","used":true,"who":"代码家"},{"_id":"582bc33d421aa93a555cfe92","createdAt":"2016-11-16T10:23:57.263Z","desc":"iOS 圆形进度条，漂亮！","images":["http://img.gank.io/a4de01da-8626-4278-8ab1-70076a5729ce"],"publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"iOS","url":"https://github.com/HamzaGhazouani/HGCircularSlider","used":true,"who":"代码家"},{"_id":"582bc361421aa93a61577f31","createdAt":"2016-11-16T10:24:33.247Z","desc":"Swift Job 队列","publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"iOS","url":"https://github.com/BrettRToomey/Jobs","used":true,"who":"代码家"}],"休息视频":[{"_id":"582a67ac421aa9102c2ec6e9","createdAt":"2016-11-15T09:41:00.851Z","desc":"人生问题：为什么吵架永远吵不过女朋友 男生内心： 你，经历过绝望吗？ ","publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"休息视频","url":"http://weibo.com/tv/v/EhxXTv9K7?fid=1034:82d69e08660431770e24fc4e48c7206d","used":true,"who":"lxxself"}],"福利":[{"_id":"582ba25b421aa93a5939d4bc","createdAt":"2016-11-16T08:03:39.788Z","desc":"11-16","publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f9tmhxq87lj20u011htae.jpg","used":true,"who":"daimajia"}]}
     */

    public boolean error;
    public ResultsBean results;
    public List<String> category;


    public class ResultsBean {

        public List<AndroidBean> Android;
        public List<IOSBean> iOS;
        public List<休息视频Bean> 休息视频;
        public List<福利Bean> 福利;


        public class AndroidBean {
            /**
             * _id : 5829b5b2421aa911e32d87e3
             * createdAt : 2016-11-14T21:01:38.860Z
             * desc : 动画插值器的编辑器
             * images : ["http://img.gank.io/fa3bb06d-1bfb-41a7-8bfe-78adeb55c049"]
             * publishedAt : 2016-11-16T11:37:18.947Z
             * source : chrome
             * type : Android
             * url : https://github.com/MartinRGB/RapidInterpolator
             * used : true
             * who : Jason
             */

            public String _id;
            public String createdAt;
            public String desc;
            public String publishedAt;
            public String source;
            public String type;
            public String url;
            public boolean used;
            public String who;
            public List<String> images;

        }

        public class IOSBean {
            /**
             * _id : 582bc2fa421aa93a555cfe90
             * createdAt : 2016-11-16T10:22:50.604Z
             * desc : 用 Touchbar 玩儿空战游戏！
             * images : ["http://img.gank.io/99ed5540-08cf-4668-890e-37fc2c08922b","http://img.gank.io/332264cd-8f9c-4191-9c96-e69e5ac01b88"]
             * publishedAt : 2016-11-16T11:37:18.947Z
             * source : chrome
             * type : iOS
             * url : https://github.com/insidegui/TouchBarSpaceFight
             * used : true
             * who : 代码家
             */

            public String _id;
            public String createdAt;
            public String desc;
            public String publishedAt;
            public String source;
            public String type;
            public String url;
            public boolean used;
            public String who;
            public List<String> images;
        }

        public class 休息视频Bean {
            /**
             * _id : 582a67ac421aa9102c2ec6e9
             * createdAt : 2016-11-15T09:41:00.851Z
             * desc : 人生问题：为什么吵架永远吵不过女朋友 男生内心： 你，经历过绝望吗？
             * publishedAt : 2016-11-16T11:37:18.947Z
             * source : chrome
             * type : 休息视频
             * url : http://weibo.com/tv/v/EhxXTv9K7?fid=1034:82d69e08660431770e24fc4e48c7206d
             * used : true
             * who : lxxself
             */

            public String _id;
            public String createdAt;
            public String desc;
            public String publishedAt;
            public String source;
            public String type;
            public String url;
            public boolean used;
            public String who;
        }

        public class 福利Bean {
            /**
             * _id : 582ba25b421aa93a5939d4bc
             * createdAt : 2016-11-16T08:03:39.788Z
             * desc : 11-16
             * publishedAt : 2016-11-16T11:37:18.947Z
             * source : chrome
             * type : 福利
             * url : http://ww3.sinaimg.cn/large/610dc034jw1f9tmhxq87lj20u011htae.jpg
             * used : true
             * who : daimajia
             */

            public String _id;
            public String createdAt;
            public String desc;
            public String publishedAt;
            public String source;
            public String type;
            public String url;
            public boolean used;
            public String who;
        }
    }
}
