import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
// create abstract class since Zone will be the parent class
public abstract class Zone 
{
    
    protected int pixWidth;
    protected int pixHeight;
    protected Color color; 

    
    public Zone(int pixWidth, int pixHeight, Color color) 
    {
        this.pixWidth = pixWidth;
        this.pixHeight = pixHeight;
        this.color = color;
    }

    // create abstract function to return Zone of the neighbor. Used in child classes
    public abstract Zone generateNeighbor();

    // create rectangle color, width, height, and outline
    public void drawSelf(Graphics g, int x, int y) 
    {
        g.setColor(color);
        g.fillRect(x, y, pixWidth, pixHeight);
        g.setColor(Color.black); 
        g.drawRect(x, y, pixWidth, pixHeight); 
    }
// return color
    public Color getColor() 
    {
        return color;
    }


    //used for ASCII testing
    @Override
    public String toString() 
    {
        return "Z"; 
    }
}
