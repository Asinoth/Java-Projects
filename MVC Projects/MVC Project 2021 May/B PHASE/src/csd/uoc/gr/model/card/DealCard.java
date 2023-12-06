package csd.uoc.gr.model.card;

public class DealCard extends Card {
    String Message;
    Double Cost, Value;
    String Choice1, Choice2;
    static int num;

    public DealCard(String msg, double cost, double value, String img_path, String choice1, String choice2) {
        this.number = num++;
        this.Choice1 = choice1;
        this.Choice2 = choice2;
        this.Message = msg;
        this.Cost = cost;
        this.img_path = img_path;
        this.Value = value;

    }

    public Double getCost() {
        return Cost;
    }

    public Double getValue() {
        return Value;
    }

    public String getChoice1() {
        return Choice1;
    }

    public String getChoice2() {
        return Choice2;
    }

    public String getMessage() {
        return Message;
    }
}
