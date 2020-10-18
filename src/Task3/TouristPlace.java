package Task3;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.*;

public class TouristPlace implements Serializable{

    String name;
    String workingHour;
    int ticketPrice;
    String city;
    float starRating;
    int numberOfRatings;
    ArrayList<String> reviews = new ArrayList<>();
    int noOfReviews;
    ArrayList<String> famousFor;
    ArrayList<TouristPlace> filterNoOfReviews = new ArrayList<>();

    public TouristPlace() {

    }

    @Override
    public String toString() {



        return String.format("Name: %s,\n Working Hour:%s,\nTicket Price:%d,\nCity:%s,Category:%s,\nStar Rating:%f,\n Number Of Reviews:%d\n\n",name.toLowerCase(),workingHour,ticketPrice,city,category,starRating,noOfReviews);


    }

    String category;



    public TouristPlace(String name, String workingHour, int ticketPrice, String city, String category) {
        this.name = name;
        this.workingHour = workingHour;
        this.ticketPrice = ticketPrice;
        this.city = city;
        this.category = category;
        starRating = 0;
        numberOfRatings=0;
        reviews = new ArrayList<>();
        famousFor = new ArrayList<>();
        noOfReviews=0;

    }

//
//    @Override
//    public String toString() {
//        return String.format("Name: %s, Working Hour:%s,Ticket Price:%d,City:%s,Category:%s,Star Rating:%f",name,workingHour,ticketPrice,city,category,starRating);
//
//    }

    public TouristPlace addReviews(String... s){
        for(String string:s) {
            noOfReviews++;
            reviews.add(string);
        }

        return this;

    }
    public int getNoOfReviews(){
        return noOfReviews;

    }



    public ArrayList<TouristPlace> getItems(TouristPlace... tp){
        for(TouristPlace t:tp ){
            filterNoOfReviews.add(t);}

        return filterNoOfReviews;
    }


    public ArrayList<TouristPlace> compareNoOfReviews(ArrayList<TouristPlace> ar){

        Collections.sort(ar, new Comparator<TouristPlace>() {
            @Override
            public int compare(TouristPlace o1, TouristPlace o2) {
                return (o1.noOfReviews- o2.noOfReviews);

            }

        });

        return ar;
    }




    void rate(int... rating){

        for(int rate:rating) {
            starRating += ((rate- starRating) / ++numberOfRatings);
        }

    }


    //replacing AM or PM from String workingHour




    boolean isPlaceOpen(String input){

        input=input.replace("AM ","AM")
                .replace("To ","To");

        String[] times=input.split("To");

        if(times[0].length()==6){
            times[0]='0'+times[0];
        }

        if(times[1].length()==6){
            times[1]='0'+times[1];
        }

        LocalTime startTime=LocalTime.parse(times[0],DateTimeFormatter.ofPattern("hh:mma")),
                endTime=LocalTime.parse(times[1],DateTimeFormatter.ofPattern("hh:mma")),
                currentTime=LocalTime.now();

        return startTime.compareTo(currentTime)<=0&&endTime.compareTo(currentTime)>=0;


    }

     public static TouristPlace newFromUserInput(){
        Scanner scan = new Scanner(System.in);
        TouristPlace place = new TouristPlace();

        System.out.println("Enter Name: ");
        place.name=scan.nextLine();

        return place;
     }








}
