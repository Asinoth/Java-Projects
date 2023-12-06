package csd.uoc.gr.model.card;

public abstract class Card {
    int number;
    String img_path;

    public int getNumber() {
        return number;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
