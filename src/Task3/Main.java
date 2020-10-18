package Task3;
import java.io.*;
import java.util.*;

public class Main {


    public static void main (String[] args) throws Exception{


        String path="C:\\Users\\tbgadmin\\IdeaProjects\\Project 5\\src\\Task3\\str.txt";



        TouristPlace touristPlace = new TouristPlace("Taj Mahal","10:44AM To 11:44PM",50,"Agra","Historical");
        TouristPlace touristPlace1 = new TouristPlace("Hawa Mahal","10:00AM To 5:00PM",50,"Jaipur","Historical");
        TouristPlace touristPlace2 = new TouristPlace("Golden Temple","12:44AM To 10:00PM",50,"Amritsar","Historical");

       // touristPlace.isPlaceOpen(touristPlace.workingHour);
        touristPlace.addReviews("It as an amazing place for knowing more about historical facts");
        touristPlace1.addReviews("It as an amazing place for knowing more about historical facts");
        touristPlace1.addReviews("It as an amazing place for knowing more about historical facts");
        touristPlace1.addReviews("It as an amazing place for knowing more about historical facts");
        touristPlace2.addReviews("It as an amazing place for knowing more about historical facts");
        touristPlace2.addReviews("It as an amazing place for knowing more about historical facts");
        touristPlace1.addReviews("It as an amazing place for knowing more about historical facts");

        System.out.println( touristPlace.getNoOfReviews());
        System.out.println(touristPlace1.getNoOfReviews());
         System.out.println(touristPlace.isPlaceOpen(touristPlace.workingHour));

        touristPlace.rate(4,3,5,2,1,4);
        touristPlace1.rate(4,3,5,2,1);
        touristPlace2.rate(4,3,5,2,1,4,3,1);


         new Menu().show();

//   ArrayList<TouristPlace> ar=touristPlace1.getItems(touristPlace,touristPlace1,touristPlace2);
//    System.out.println( touristPlace2.compareNoOfReviews(ar));

        ArrayList<TouristPlace> filterStarRating = new ArrayList<>(
                Arrays.asList(touristPlace,touristPlace1,touristPlace2)
        );
        Collections.sort(filterStarRating, new Comparator<TouristPlace>() {
            @Override
            public int compare(TouristPlace o1, TouristPlace o2) {
                return (int) (o1.starRating*1000- o2.starRating*1000);
            }
        });


System.out.println(filterStarRating);





        System.out.println(touristPlace.starRating);
        System.out.println(touristPlace.reviews);







    }













}




