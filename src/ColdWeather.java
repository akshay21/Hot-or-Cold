import java.util.ArrayList;

/**
 * Created by Akshay on 6/14/2017.
 */
public class ColdWeather {
    //Creating flags.
    boolean hasPajamas=true;

    boolean hasFootwear = false;

    boolean hasHeadwear = false;

    boolean hasSocks = false;

    boolean hasShirt= false;

    boolean hasJacket = false;

    boolean hasPants = false;

    boolean inHouse = true;

    public ArrayList<String> clothing (ArrayList<Integer> inputArr){

        ArrayList <String> str=new ArrayList<String>();
        for (int command:inputArr){       //Going through the list of commands given by the user.
            if(command==8 && hasPajamas&& inHouse){ //Checking if the person is in the house and wearing pajamas.
                hasPajamas=false;              //Command 8 says to remove PJs.
                str.add("Removing PJs, ");
            }
            else if (command==6 && !hasFootwear && !hasSocks && !hasPants && inHouse ){
                hasPants=true;              //Command 6 says to wear pants before socks or footwear.
                str.add("pants, ");
            }
            else if (command==3 && !hasFootwear && !hasSocks && hasPants && inHouse ){
                hasSocks=true;              //Command 3 says to wear socks before wearing boots
                str.add("socks, ");
            }
            else if(command==1 && !hasFootwear && hasSocks && hasPants && inHouse){
                hasFootwear=true;           //Command 1 says to wear boots as it is cold outside.
                str.add("boots, ");
            }
            else if(command==4 && !hasShirt && !hasJacket && !hasHeadwear && inHouse){
                hasShirt=true;              //Command 4 says to wear shirt before wearing headwear.
                str.add("shirt, ");
            }
            else if(command==2 && hasShirt && !hasHeadwear && inHouse){
                hasHeadwear=true;           //Command 2 says to wear hat as it is cold outside.
                str.add("hat, ");
            }
            else if(command==5 && hasShirt && !hasJacket && inHouse){
                hasJacket=true;           //Command 5 says to wear jacket as it is cold outside.
                str.add("jacket, ");
            }
            else if(command==7 && inHouse && hasShirt && hasHeadwear && hasPants
                    && hasFootwear && hasJacket && hasSocks){
                inHouse=false;              //The person should leave the house only if the person
                str.add("leaving house");   //is properly dressed for the weather outside.
                return str;
            }
            else {
                str.add("fail");
                return str;
            }
        }
        return str;
    }

}
