import java.util.ArrayList;

/**
 * Created by Akshay on 6/13/2017.
 */
public class HotWeather {
    //Creating flags.
    boolean hasPajamas=true;

    boolean hasFootwear = false;

    boolean hasHeadwear = false;

    boolean hasSocks = false;

    boolean hasShirt= false;

    boolean hasJacket = false;

    boolean hasPants = false;

    boolean inHouse = true;

    public  ArrayList<String> clothing (ArrayList<Integer> inputArr){

        ArrayList <String> str=new ArrayList<String>();
        for (int i:inputArr){ //Going through the list of commands given by the user.
            if(i==8 && hasPajamas&& inHouse){ //Checking if the person is in the house and wearing pajamas.
                hasPajamas=false;       //Command 8 says to remove PJs.
                str.add("Removing PJs, ");
                if (i==6 && !hasFootwear && !hasSocks && !hasPants && inHouse ){
                    hasPants=true;          //Command 6 says to wear pants before socks or footwear.
                    str.add("shorts, ");
                }
                else if (i==3 ){
                    str.add("fail");        //As the weather is hot person doesn't need to wear socks.
                    return str;             //Thus if the command given to wear socks should return fail.
                }
                else if(i==1 && !hasFootwear && !hasSocks && hasPants && inHouse){
                    hasFootwear=true;       //Command 1 says to wear sandals as it is hot outside.
                    str.add("sandals, ");
                }
                else if(i==4 && !hasShirt && !hasJacket && !hasHeadwear && inHouse){
                    hasShirt=true;          //Command 4 says to wear t-shirt before wearing headwear.
                    str.add("t-shirt, ");
                }
                else if(i==2 && hasShirt && !hasJacket && !hasHeadwear && inHouse){
                    hasHeadwear=true;       //Command 2 says to wear sun visor as it is hot outside.
                    str.add("sun visor, ");
                }
                else if(i==5){
                    str.add("fail");        //As the weather is hot person doesn't need to wear jacket.
                    return str;             //Thus if the command given to wear jacket should return fail.
                }
                else if(i==7 && inHouse && hasShirt && hasHeadwear && hasPants
                        && hasFootwear && !hasJacket && !hasSocks){
                    inHouse=false;              //The person should leave the house only if the person
                    str.add("leaving house");   //is properly dressed for the weather outside.
                    return str;
                }
                else {
                    str.add("fail");
                    return str;
                }
            }

            else {
                str.add("fail");
                return str;
            }
        }
        return str;
    }
}
