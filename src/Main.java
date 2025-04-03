/*
 Nathan Munro
 CPI 221
 Professor Selgrad
 2/16/25
 
 Description: In this program we create a city using a 2d array of zones. These zones are all children of the "zone" class which all have different colors and probability of having a 
 new zone spawn near them. I create and render the city in two different classes as well, using slick2D. 
 */
import java.util.Scanner;
import org.newdawn.slick.*;
public class Main 
{
    public static void main(String[] args) 
    {
    	//create try-catch for Slick2d AppGameContainer
    	try 
    	{
            //Get inputed responses
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter city width (20-50): ");
            int cityWidth = scanner.nextInt();
            System.out.print("Enter city height (20-50): ");
            int cityHeight = scanner.nextInt();
            scanner.close();

            // Ensure valid numbers
            if (cityWidth < 20 || cityWidth > 50 || cityHeight < 20 || cityHeight > 50) {
                System.out.println("Invalid city size! Please enter values between 20 and 50.");
                return;
            }

            // Create window for the visuals
            AppGameContainer app = new AppGameContainer(new CityRenderer(cityWidth, cityHeight));
            app.setDisplayMode(800, 600, false);
            app.start();

        } 
    	catch (SlickException e) 
    	{
            e.printStackTrace();
        }
    }

    // Returns a random starting zone
    public static Zone getRandomZone(int pixWidth, int pixHeight) 
    {
        int choice = (int) (Math.random() * 6); 

        if (choice == 0) 
        {
            return new HighDenResidential(pixWidth, pixHeight);
        } else if (choice == 1) 
        {
            return new AverageDenResidential(pixWidth, pixHeight);
        } else if (choice == 2) 
        {
            return new LowDenResidential(pixWidth, pixHeight);
        } else if (choice == 3) 
        {
            return new Commercial(pixWidth, pixHeight);
        } else if (choice == 4) 
        {
            return new Industrial(pixWidth, pixHeight);
        } else 
        {
            return new RecreationSpace(pixWidth, pixHeight);
        }
    }

}
