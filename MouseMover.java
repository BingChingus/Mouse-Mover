import java.awt.Robot;
import java.util.Random;

// 7-5-23
public class MouseMover
{
    //tf does throws exception mean, how tf do throws work
    public static void main(String[] args) throws Exception
    {
        final int MAX_X = 400;
        final int MAX_Y = 400;
        int start_x     = 0;
        int start_y     = 0;

        Robot mouse = new Robot();
        Random rNum = new Random();

        mouse.setAutoDelay(1);

        while(true)
        {
            //generates random point in a 400x400 space
            int end_x = rNum.nextInt(MAX_X);
            int end_y = rNum.nextInt(MAX_Y);

            //loop slowly moves cursor towards said point
            for(int i = 0; i < 1000; i++)
            {
                int x = ((end_x * i) / 1000) + (start_x * (1000 - i) / 1000);
                int y = ((end_y * i) / 1000) + (start_y * (1000 - i) / 1000);
                mouse.mouseMove(x,y);
            }

            //start where cursor ends next time
            start_x = end_x;
            start_y = end_y;
            
            Thread.sleep(5000);
        }

    }
}
