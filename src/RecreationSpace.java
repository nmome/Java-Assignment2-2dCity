import org.newdawn.slick.Color;
import java.util.Random;

public class RecreationSpace extends Zone 
{
    private static final Random random = new Random(); 

    //Create new zone using the parent constructor
    public RecreationSpace(int pixWidth, int pixHeight) 
    {
        super(pixWidth, pixHeight, Color.blue); 
    }

    //get next neighbor
    @Override
    public Zone generateNeighbor() 
    {
        int chance = random.nextInt(100); 

        if (chance < 5) return new HighDenResidential(pixWidth, pixHeight); 
        else if (chance < 15) return new AverageDenResidential(pixWidth, pixHeight); 
        else if (chance < 40) return new LowDenResidential(pixWidth, pixHeight); 
        else if (chance < 55) return new Commercial(pixWidth, pixHeight); 
        else return new RecreationSpace(pixWidth, pixHeight); 
    }

    
    @Override
    public String toString() 
    {
        return "R"; 
    }
}
