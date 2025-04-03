import org.newdawn.slick.Color;
import java.util.Random;

public class Industrial extends Zone 
{
    private static final Random random = new Random(); 

    //Create new zone using the parent constructor
    public Industrial(int pixWidth, int pixHeight) 
    {
        super(pixWidth, pixHeight, Color.red); 
    }

    //get next neighbor
    @Override
    public Zone generateNeighbor() 
    {
        int chance = random.nextInt(100); 

        if (chance < 20) return new HighDenResidential(pixWidth, pixHeight);
        else if (chance < 25) return new AverageDenResidential(pixWidth, pixHeight); 
        else if (chance < 45) return new Commercial(pixWidth, pixHeight); 
        else if (chance < 95) return new Industrial(pixWidth, pixHeight); 
        else return new RecreationSpace(pixWidth, pixHeight); 
    }

    
    @Override
    public String toString() 
    {
        return "I"; 
    }
}
