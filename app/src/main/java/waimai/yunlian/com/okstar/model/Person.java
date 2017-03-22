package waimai.yunlian.com.okstar.model;

/**
 * Created by Stran on 2016/12/20.
 */
public class Person {

    private int    imageId;
    private String tv;




    public Person(int imageId, String tv) {
        this.imageId = imageId;
        this.tv = tv;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    @Override
    public String toString() {
        return "Person{" +
                "imageId=" + imageId +
                ", tv='" + tv + '\'' +
                '}';
    }
}
