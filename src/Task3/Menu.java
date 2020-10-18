package Task3;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Menu implements Serializable {

    private static final String FILE_PATH = "C:\\Users\\tbgadmin\\IdeaProjects\\Project 5\\src\\Task3\\str.txt";
    HashMap<String,TouristPlace> map=new HashMap<>();

    public void show() throws Exception{
              readMap();
        while (true){

          int choice=showMenuAndGetChoice();

          switch(choice){

              case 1: addANewPlace();
              break;

              case 2: findAPlace();
              break;

              case 3: rateThisPlace();
              break;

              case 4: removeAPlace();
              break;

              default:System.out.println("Invalid Choice");

          }
          showPlaces();
          if(wantsToExit()){
              saveFile();
              break;
          }





        }

    }

    private void readMap() {

        try {
            String path = "C:\\Users\\tbgadmin\\IdeaProjects\\Project 5\\src\\Task3\\str.txt";

            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
           HashMap<String,TouristPlace> map=(HashMap<String, TouristPlace>)ois.readObject();
           System.out.println(map.values().toString());
        }
        catch (Exception e){
            map=new HashMap<>();
            return;

        }



        showPlaces();


    }
    private void saveFile() throws IOException {
        String path = "C:\\Users\\tbgadmin\\IdeaProjects\\Project 5\\src\\Task3\\str.txt";



        FileOutputStream fos = new FileOutputStream(path);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(map);
        oos.close();
        fos.close();



    }

    private void showPlaces() {
        System.out.println("Places  "+map.values().toString());
    }


    public boolean wantsToExit(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Would you like to continue? (y/n)");
        String input = scan.next();
        return  input.equals("n");
    }




    private void removeAPlace() {
        Scanner scan=new Scanner(System.in);
        String placeName=scan.nextLine();
        if(map.containsKey(placeName.toLowerCase())){

            map.remove(placeName.toLowerCase());


        }
        else{
            System.out.println("Place Not Found");
        }



    }


    private void rateThisPlace() {

        Scanner scan=new Scanner(System.in);
         String placeName=scan.nextLine();





        if(map.containsKey(placeName.toLowerCase())){

            TouristPlace touristPlace = map.get(placeName.toLowerCase());

            int rate=scan.nextInt();
            if(rate>=1&&rate<=5){

                touristPlace.rate(rate);
            }
            else {
                System.out.println("Invalid Input");
            }


        }
        else {
            System.out.println("Place Not Found");
        }

    }

    private void findAPlace() {

        Scanner scan=new Scanner(System.in);
        String placeName=scan.nextLine();
        if(map.containsKey(placeName.toLowerCase())){

            System.out.println("Place Found!");


        }
        else{
            System.out.println("Place Not Found");
        }



    }

    private void addANewPlace() {
        TouristPlace place= TouristPlace.newFromUserInput();
        map.put(place.name.toLowerCase(),place);

        System.out.println(" Place Added !!");



    }

    private int showMenuAndGetChoice(){
     System.out.println("\n\n ******************Menu*****************");
        System.out.println("1.Add new place");
        System.out.println("2.Find a place");
        System.out.println("3.Rate This place");
        System.out.println("4.Remove a place");
        System.out.println("5.Review a place");
        System.out.println("6.Get No. of reviews");
        System.out.print("Enter your choice :");

        return new Scanner(System.in).nextInt();





    }




}
