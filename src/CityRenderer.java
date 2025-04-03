import org.newdawn.slick.*;

public class CityRenderer extends BasicGame 
{
    private CityGenerator city;
    private int cityWidth;
    private int cityHeight;
    private int pixWidth;
    private int pixHeight;
    

    // Constructor
    public CityRenderer(int cityWidth, int cityHeight) 
    {
        super("Procedural City Generation");
        this.cityWidth = cityWidth;
        this.cityHeight = cityHeight;
        this.pixWidth = 800 / cityWidth;  
        this.pixHeight = 600 / cityHeight;
    }
    //initialize
    @Override
    public void init(GameContainer gc) throws SlickException 
    {
        // Generate the city
        city = new CityGenerator(cityWidth, cityHeight, pixWidth, pixHeight);
        city.generateCity();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException 
    {
        //nothing needed
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException 
    {
        Zone[][] cityGrid = city.getCityGrid();

        // Draw each zone as a rectangle
        for (int y = 0; y < cityHeight; y++) 
        {
            for (int x = 0; x < cityWidth; x++) 
            {
                Zone zone = cityGrid[y][x];

                if (zone != null) 
                {
                    g.setColor(zone.getColor()); // Set color based on zone
                    g.fillRect(x * pixWidth, y * pixHeight, pixWidth, pixHeight); // Draw the zone
                    g.setColor(Color.black);
                    g.drawRect(x * pixWidth, y * pixHeight, pixWidth, pixHeight); // Draw border
                }
            }
        }
    }
}
