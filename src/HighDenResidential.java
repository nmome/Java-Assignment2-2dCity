import org.newdawn.slick.Color;
import java.util.Random;

public class HighDenResidential extends Zone 
{
    Random random = new Random(); 

    
    public HighDenResidential(int pixWidth, int pixHeight) 
    {
        super(pixWidth, pixHeight, Color.darkGray); //links to parent class
    }

    //Override parent function to find chances of generating the next neighbor for this specific zone
    @Override
    public Zone generateNeighbor() 
    {
        int chance = random.nextInt(100); 

        if (chance < 40) return new HighDenResidential(pixWidth, pixHeight); 
        else if (chance < 60) return new AverageDenResidential(pixWidth, pixHeight); 
        else if (chance < 80) return new Commercial(pixWidth, pixHeight); 
        else if (chance < 90) return new Industrial(pixWidth, pixHeight); 
        else return new RecreationSpace(pixWidth, pixHeight); 
    }

    
    @Override
    public String toString() 
    {
        return "H"; 
    }
}
