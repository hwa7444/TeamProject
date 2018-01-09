package codefactory.learfletproject;

/**
 * Created by Byungwoo on 2018-01-09.
 */

public class RecoCouponVO {
    int recoImage;
    String recoStoreName;
    String recoCouponInfo;

    public int getRecoImage() {
        return recoImage;
    }

    public void setRecoImage(int recoImage) {
        this.recoImage = recoImage;
    }

    public String getRecoStoreName() {
        return recoStoreName;
    }

    public void setRecoStoreName(String recoStoreName) {
        this.recoStoreName = recoStoreName;
    }

    public String getRecoCouponInfo() {
        return recoCouponInfo;
    }

    public void setRecoCouponInfo(String recoCouponInfo) {
        this.recoCouponInfo = recoCouponInfo;
    }

    public RecoCouponVO(int recoImage, String recoStoreName, String recoCouponInfo) {
        this.recoImage = recoImage;
        this.recoStoreName = recoStoreName;
        this.recoCouponInfo = recoCouponInfo;
    }
}