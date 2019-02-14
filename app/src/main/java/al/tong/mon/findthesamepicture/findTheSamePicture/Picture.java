package al.tong.mon.findthesamepicture.findTheSamePicture;

class Picture {

    private String display;
    private String tag;
    private int check = 0;

    Picture(String display, String tag) {
        this.display = display;
        this.tag = tag;
    }

    String getDisplay() {
        return display;
    }

    String getTag() {
        return tag;
    }

    int getCheck() {
        return check;
    }

    void setDisplay(String display) {
        this.display = display;
    }

    void setTag(String tag) {
        this.tag = tag;
    }

    void setCheck(int check) {
        this.check = check;
    }
}
