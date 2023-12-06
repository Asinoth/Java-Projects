package csd.uoc.gr.model.card;

public class MailCard extends Card {
    static int num = 0;
    //    Message,Choice,Euro,Icon
    String Message, Choice;
    Double Euro;

    public enum MailType {
        Advertisment,
        Bill,
        Charity,
        PayTheNeighbor,
        MadMoney,
        MoveToDealBuyer
    }

    MailType mailType;

    public MailCard(String msg, String choice, double euro, String icon, MailType mailType) {
        this.number = num++;
        this.img_path = icon;
        this.Message = msg;
        this.Choice = choice;
        this.Euro = euro;
        this.mailType = mailType;
    }

    public MailType getMailType() {
        return mailType;
    }

    public Double getEuro() {
        return Euro;
    }
}
