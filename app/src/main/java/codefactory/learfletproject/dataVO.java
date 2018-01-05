package codefactory.learfletproject;

/**
 * Created by jhyoo on 2018-01-05.
 */

public class dataVO {
    private int draw;
    private String id;
    private String time;


    public dataVO(int draw, String id, String time) {
        this.draw = draw;
        this.id = id;
        this.time = time;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


