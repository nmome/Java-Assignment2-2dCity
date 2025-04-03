import org.newdawn.slick.Color;
import java.util.Random;

public class AverageDenResidential extends Zone 
{
    Random random = new Random();

    //Create new zone using the parent constructor
    public AverageDenResidential(int pixWidth, int pixHeight) 
    {
        super(pixWidth, pixHeight, Color.gray); 
    }

  //get next neighbor
    @Override
    public Zone generateNeighbor() 
    {
        int chance = random.nextInt(100); 

        if (chance < 20) return new HighDenResidential(pixWidth, pixHeight); 
        else if (chance < 50) return new AverageDenResidential(pixWidth, pixHeight); 
        else if (chance < 55) return new LowDenResidential(pixWidth, pixHeight); 
        else if (chance < 75) return new Commercial(pixWidth, pixHeight); 
        else if (chance < 80) return new Industrial(pixWidth, pixHeight); 
        else return new RecreationSpace(pixWidth, pixHeight); 
    }

    
    @Override
    public String toString() 
    {
        return "A"; 
    }
}
