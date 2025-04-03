public class CityGenerator 
{
    private int width;
    private int height;
    private int pixWidth;
    private int pixHeight;
    
    private Zone[][] cityGrid;

    // Constructor with dimensions and pixel size
    public CityGenerator(int width, int height, int pixWidth, int pixHeight) 
    {
        this.width = width;
        this.height = height;
        this.pixWidth = pixWidth;
        this.pixHeight = pixHeight;
        this.cityGrid = new Zone[height][width]; // 2D array for the city
    }

    //create the city using for loops
    public void generateCity() 
    {
        // Set a random zone to the top left of the grid
        cityGrid[0][0] = Main.getRandomZone(pixWidth, pixHeight);

        // create the first row
        for (int x = 1; x < width; x++) 
        {
            cityGrid[0][x] = cityGrid[0][x - 1].generateNeighbor();
        }

        // create the remaining rows
        for (int y = 1; y < height; y++) 
        {
            for (int x = 0; x < width; x++) 
            {
                if (x == 0) 
                {
                    // Check for the first row
                    cityGrid[y][x] = cityGrid[y - 1][x].generateNeighbor();
                } 
                else 
                {
                    // flip a coin to decide left or upper neighbor
                    if (Math.random() < 0.5) 
                    {
                        cityGrid[y][x] = cityGrid[y][x - 1].generateNeighbor(); // Use to the left neighbor
                    } 
                    else 
                    {
                        cityGrid[y][x] = cityGrid[y - 1][x].generateNeighbor(); // Use up from neighbor
                    }
                }
            }
        }
    }
    //return grid
    public Zone[][] getCityGrid() 
    {
        return cityGrid;
    }

   
}
