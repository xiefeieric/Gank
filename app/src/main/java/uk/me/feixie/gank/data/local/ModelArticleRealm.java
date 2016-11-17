package uk.me.feixie.gank.data.local;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Fei on 16/11/2016.
 */

public class ModelArticleRealm extends RealmObject {

    @PrimaryKey
    public String id;
    public String creatAt;
    public String desc;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String author;
    public RealmList<RealmString> imagePaths;

}
