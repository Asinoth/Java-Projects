package model.card;

/**
 * This class creates a new Mahjong Card
 * 
 */
public class Mahjong extends SpecialCard
{
    /**
     * <b>constructor</b>: Constructs a new instance of Mahjong and via 
     * the parent class SpecialCard
     * sets with the command super ,value=1,points=0 and its type=Mahjong
     */
    public Mahjong()
    {
        super(1,0,"Mahjong");
    }
}
