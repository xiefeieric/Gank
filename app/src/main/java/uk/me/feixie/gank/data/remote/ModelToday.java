package uk.me.feixie.gank.data.remote;

import java.util.List;

import io.realm.Realm;
import uk.me.feixie.gank.data.local.ModelArticleRealm;

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
        public List<拓展资源Bean> 拓展资源;


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

            public void toRealmItemAndroid(final AndroidBean android, Realm realm) {

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        ModelArticleRealm androidRealm = realm.where(ModelArticleRealm.class).equalTo("id", android._id).findFirst();
                        if (androidRealm == null) {
                            androidRealm = new ModelArticleRealm();
                            androidRealm.id = android._id;
                        }
                        androidRealm.creatAt = android.createdAt;
                        androidRealm.desc = android.desc;
                        androidRealm.publishedAt = android.publishedAt;
                        androidRealm.source = android.source;
                        androidRealm.type = android.type;
                        androidRealm.url = android.url;
                        androidRealm.used = android.used;
                        androidRealm.author = android.who;
                        if (android.images != null && android.images.size() > 0) {
                            androidRealm.imagePath = android.images.get(0);
                        }
                        realm.copyToRealmOrUpdate(androidRealm);
                    }
                });
            }

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

            public void toRealmItemIos(final IOSBean ios, Realm realm) {

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        ModelArticleRealm iosRealm = realm.where(ModelArticleRealm.class).equalTo("id", ios._id).findFirst();
                        if (iosRealm == null) {
                            iosRealm = new ModelArticleRealm();
                            iosRealm.id = ios._id;
                        }
                        iosRealm.creatAt = ios.createdAt;
                        iosRealm.desc = ios.desc;
                        iosRealm.publishedAt = ios.publishedAt;
                        iosRealm.source = ios.source;
                        iosRealm.type = ios.type;
                        iosRealm.url = ios.url;
                        iosRealm.used = ios.used;
                        iosRealm.author = ios.who;
                        if (ios.images != null && ios.images.size() > 0) {
                            iosRealm.imagePath = ios.images.get(0);
                        }
                        realm.copyToRealmOrUpdate(iosRealm);
                    }
                });
            }
        }

        public class 拓展资源Bean {
            /**
             * "_id": "5833ee27421aa926e6fa8396",
             * "createdAt": "2016-11-22T15:05:11.688Z",
             * "desc": "itCoder WeeklyBlog 第六期（Android：沉浸式适配、Retrofit 2.0 应用 、Android 单元测试-Mock及Mockito 、自定义选择复制功能、RxJava 学习笔记（部分示例代码及源码）、使用贝塞尔曲线实现仿 QQ “一键下班”；C/C++：Linux 下用 Clion 编写及调用共享库 ；Python：Python 描述符入门指北、Atom-Helper 小脚本；面向对象：面向对象六大原则和设计模式。）",
             * "publishedAt": "2016-11-23T11:27:52.847Z",
             * "source": "web",
             * "type": "拓展资源",
             * "url": "http://itscoder.com/weeklyblog-phase-6/",
             * "used": true,
             * "who": null
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

            public void toRealmItemSource(final 拓展资源Bean source, Realm realm) {

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        ModelArticleRealm sourceRealm = realm.where(ModelArticleRealm.class).equalTo("id", source._id).findFirst();
                        if (sourceRealm == null) {
                            sourceRealm = new ModelArticleRealm();
                            sourceRealm.id = source._id;
                        }
                        sourceRealm.creatAt = source.createdAt;
                        sourceRealm.desc = source.desc;
                        sourceRealm.publishedAt = source.publishedAt;
                        sourceRealm.source = source.source;
                        sourceRealm.type = source.type;
                        sourceRealm.url = source.url;
                        sourceRealm.used = source.used;
                        sourceRealm.author = source.who;

                        realm.copyToRealmOrUpdate(sourceRealm);
                    }
                });
            }
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

            public void toRealmItemLeisure(final 休息视频Bean leisure, Realm realm) {

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        ModelArticleRealm leisureRealm = realm.where(ModelArticleRealm.class).equalTo("id", leisure._id).findFirst();
                        if (leisureRealm == null) {
                            leisureRealm = new ModelArticleRealm();
                            leisureRealm.id = leisure._id;
                        }
                        leisureRealm.creatAt = leisure.createdAt;
                        leisureRealm.desc = leisure.desc;
                        leisureRealm.publishedAt = leisure.publishedAt;
                        leisureRealm.source = leisure.source;
                        leisureRealm.type = leisure.type;
                        leisureRealm.url = leisure.url;
                        leisureRealm.used = leisure.used;
                        leisureRealm.author = leisure.who;
                        realm.copyToRealmOrUpdate(leisureRealm);
                    }
                });
            }
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

            public void toRealmItemGift(final 福利Bean gift, Realm realm) {


                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        ModelArticleRealm giftRealm = realm.where(ModelArticleRealm.class).equalTo("id", gift._id).findFirst();
                        if (giftRealm == null) {
                            giftRealm = new ModelArticleRealm();
                            giftRealm.id = gift._id;
                        }
                        giftRealm.creatAt = gift.createdAt;
                        giftRealm.desc = gift.desc;
                        giftRealm.publishedAt = gift.publishedAt;
                        giftRealm.source = gift.source;
                        giftRealm.type = gift.type;
                        giftRealm.url = gift.url;
                        giftRealm.used = gift.used;
                        giftRealm.author = gift.who;
                        realm.copyToRealmOrUpdate(giftRealm);
                    }
                });
            }
        }
    }
}
