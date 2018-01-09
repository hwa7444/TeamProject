package codefactory.learfletproject;

/**
 * Created by Byungwoo on 2018-01-09.
 */

public class MyCouponVO {

    private int image;
    private String couponContents;
    private String couponValidity;


    private String couponInfo;


    public MyCouponVO(int image, String couponContents, String couponValidity, String couponInfo) {
        this.image = image;
        this.couponContents = couponContents;
        this.couponValidity = couponValidity;
        this.couponInfo = couponInfo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCouponContents() {
        return couponContents;
    }

    public void setCouponContents(String couponContents) {
        this.couponContents = couponContents;
    }

    public String getCouponValidity() {
        return couponValidity;
    }

    public void setCouponValidity(String couponValidity) {
        this.couponValidity = couponValidity;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

}
