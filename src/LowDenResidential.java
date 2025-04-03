import org.newdawn.slick.Color;
import java.util.Random;

public class LowDenResidential extends Zone 
{
    private static final Random random = new Random(); 

  //Create new zone using the parent constructor
    public LowDenResidential(int pixWidth, int pixHeight) 
    {
        super(pixWidth, pixHeight, Color.lightGray); 
    }

   //get next neighbor
    @Override
    public Zone generateNeighbor() 
    {
        int chance = random.nextInt(100); 

        if (chance < 20) return new AverageDenResidential(pixWidth, pixHeight); 
        else if (chance < 60) return new LowDenResidential(pixWidth, pixHeight); 
        else if (chance < 65) return new Commercial(pixWidth, pixHeight); 
        else return new RecreationSpace(pixWidth, pixHeight); 
    }

    
    @Override
    public String toString() 
    {
        return "L"; 
    }
}
