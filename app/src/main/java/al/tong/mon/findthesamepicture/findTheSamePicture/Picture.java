package al.tong.mon.findthesamepicture.findTheSamePicture;

class Picture {

    private int display;
    private String tag;
    private int check = 0;

    Picture(int display, String tag) {
        this.display = display;
        this.tag = tag;
    }

    int getDisplay() {
        return display;
    }

    String getTag() {
        return tag;
    }

    int getCheck() {
        return check;
    }

    void setDisplay(int display) {
        this.display = display;
    }

    void setTag(String tag) {
        this.tag = tag;
    }

    void setCheck(int check) {
        this.check = check;
    }
}
