import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Akshay on 6/13/2017.
 */
public class HotOrCold {
    public static void main(String[] args) {

        ArrayList<String> answer=new ArrayList<String>();//For storing final result
        //Taking input from STDIN from user
        Scanner scanner=new Scanner(System.in);
        //Taking only the integers from the input.
        HotWeather hot= new HotWeather();//Creating objects of weather type classes
        ColdWeather cold=new ColdWeather();

        String weather=scanner.next();
        String input=scanner.nextLine();
        String[] splitStr=input.split("(|,|\\s)\\s+");
        ArrayList <Integer> inputArr=new ArrayList<>();

        try {
            for (String x : splitStr) {
                if (!(x.equals(""))) {
                    inputArr.add(Integer.parseInt(x));
                }
            }

            //Creating a list of commands given by user.

            if (weather.equals("HOT")) {
                answer = hot.clothing(inputArr);
            } else if (weather.equals("COLD")) {
                answer = cold.clothing(inputArr);
            }
            for (String str : answer) {
                System.out.print(str);
            }

        }
        catch (Exception e){
            System.out.println("Invalid input! Please enter correct input");
        }

    }
}
