package newp;


import java.io.FileWriter;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws Exception {

        StorePrice storePrice = new StorePrice();
        StoreDate storeDate = new StoreDate();
        LinkedListForFlights linkedListForFlights = new LinkedListForFlights();
        StoreFromCity storeFromCity = new StoreFromCity();


        int option = 1;
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME");
        while (option >= 1 && option <= 8) {
            System.out.println("1)INSERT flight information.\n" +
                    "2)REMOVE flight information.\n" +
                    "3)Search for flights by DATE.\n" +
                    "4)Search for flights by FROM city.\n" +
                    "5)Search for flights with both FROM city and DATE.\n" +
                    "6)Search for flights BETWEEN TWO DATES.\n" +
                    "7)Search for flights less than a given PRICE in a given DATE.\n" +
                    "8)Print info. ");
            option = input.nextInt();

            if (option == 1) {
                System.out.println("Date:");
                System.out.print("day: ");
                int day = input.nextInt();
                System.out.print("month: ");
                int month = input.nextInt()-1;
                System.out.print("year: ");
                int year = input.nextInt();
                Date date = new Date(year, month, day);

                System.out.println();
                System.out.println("Time: ");
                System.out.print("Hour: ");
                int hour = input.nextInt();
                System.out.print("Minute: ");
                int minute = input.nextInt();
                LocalTime time = LocalTime.of(hour, minute);

                System.out.println();
                System.out.print("From: ");
                String from = input.next();
                System.out.print("To: ");
                String to = input.next();
                System.out.print("Carrier: ");
                String carrier = input.next();
                System.out.print("Price: ");
                int price = input.nextInt();

                Flight f1 = new Flight(date, time, from, to, carrier, price);
                linkedListForFlights.insert(date, time, from, to, carrier, price);
                storeDate.root = storeDate.insert(storePrice.root, f1.date, f1.time, f1.from, f1.to, f1.carrier, f1.price);
                storePrice.root = storePrice.insert(storePrice.root, f1.price, f1.date, f1.time, f1.from, f1.to, f1.carrier);
                storeFromCity.root = storeFromCity.insert(storeFromCity.root, f1.from, f1.date, f1.time, f1.to, f1.carrier, f1.price);
                System.out.println();

            }
            if (option == 2) {
                if (linkedListForFlights.first==null) {
                    System.out.println("silinecek bir uçuş yok");
                } else{
                System.out.println("please enter all informations about flight");
                System.out.println("Date:");
                System.out.print("day: ");
                int day = input.nextInt();
                System.out.print("month: ");
                int month = input.nextInt()-1;
                System.out.print("year: ");
                int year = input.nextInt();
                Date date = new Date(year, month, day);

                System.out.println();
                System.out.println("Time: ");
                System.out.print("Hour: ");
                int hour = input.nextInt();
                System.out.print("Minute: ");
                int minute = input.nextInt();
                LocalTime time = LocalTime.of(hour, minute);

                System.out.println();
                System.out.print("From: ");
                String from = input.next();
                System.out.print("To: ");
                String to = input.next();
                System.out.print("Carrier: ");
                String carrier = input.next();
                System.out.print("Price: ");
                int price = input.nextInt();
                Flight f1 = new Flight(date, time, from, to, carrier, price);

                // SİLMEK İSTİYORSUN SEN BURDA LİSTEDE OLMADAN OBJEYİ SİLMEYE ÇALIŞIYORSUN O YÜZDEN DE HATA ALIYORSUN
                // VERDİĞİ DEĞERLERE UYAN UÇUŞ VAR MI ONA BAKACAKSIN VARSA ONU SİLECEKSİN
               // System.out.println(linkedListForFlights.search(f1));
                linkedListForFlights.delete(f1);
              //  linkedListForFlights.deleteNode(f2); //// VAR OLAN UÇUŞU NULL OLARAK BULDUM.

                storeDate.deleteDate(storeDate.root, f1.date);
                 storeFromCity.deleteNode(storeFromCity.root,f1.from);
                storePrice.deleteNode(storePrice.root, f1.price);}
                System.out.println();
            }


            if (option == 3) {  //"3)Search for flights by DATE
                if (storeDate.root==null) {
                    System.out.println("herhangi bir uçuş eklemediniz. ");
                } else {
                System.out.println("Date:");
                System.out.print("day: ");
                int day = input.nextInt();
                System.out.print("month: ");
                int month = input.nextInt()-1;
                System.out.print("year: ");
                int year = input.nextInt();
                Date date = new Date(year, month, day);
                storeDate.search(date);}
                System.out.println();
            }

            if (option == 4) {   //"4)Search for flights by FROM city.
                if (storeFromCity.root==null) {
                    System.out.println("herhangi bir uçuş eklemediniz. ");
                }
                else {
                System.out.print("From: ");
                String from = input.next();
                storeFromCity.search(from).toStringg();
            }  System.out.println(); }


            if (option == 5) {  //5)Search for flights with both FROM city and DATE.
                if (storeFromCity.root == null) {
                    System.out.println("herhangi bir uçuş eklemediniz. ");
                } else {
                    System.out.println("Date:");
                    System.out.print("day: ");
                    int day = input.nextInt();
                    System.out.print("month: ");
                    int month = input.nextInt() - 1;
                    System.out.print("year: ");
                    int year = input.nextInt();
                    Date date = new Date(year, month, day);
                    System.out.println();
                    System.out.print("From: ");
                    String from = input.next();


                    if (storeDate.search(date) == storeFromCity.search(from)) {
                       storeFromCity.search(from).toStringg();
                    }

                }
                System.out.println();
            }


            if (option == 6) { //"6)Search for flights BETWEEN TWO DATES
                if (storeDate.root==null) {
                    System.out.println("herhangi bir uçuş eklemediniz.");
                } else {
                System.out.println("First Date:");
                System.out.print("day: ");
                int day = input.nextInt();
                System.out.print("month: ");
                int month = input.nextInt()-1;
                System.out.print("year: ");
                int year = input.nextInt();
                Date date = new Date(year, month, day);

                System.out.println("Second Date:");
                System.out.print("day: ");
                int day2 = input.nextInt();
                System.out.print("month: ");
                int month2 = input.nextInt()-1;
                System.out.print("year: ");
                int year2 = input.nextInt();
                Date date2 = new Date(year2, month2, day2);
                storeDate.searchBetween2Dates(date, date2).toStringg();
                }
                System.out.println();
            }


            if (option == 7) {  //7)Search for flights less than a given PRICE in a given DATE.
                if (storeDate.root==null) {
                    System.out.println("herhangi bir uçuş eklemediniz. ");
                } else {
                System.out.println("Date:");
                System.out.print("day: ");
                int day = input.nextInt();
                System.out.print("month: ");
                int month = input.nextInt() - 1;
                System.out.print("year: ");
                int year = input.nextInt();
                Date date = new Date(year, month, day);

                System.out.print("Price: ");
                int price = input.nextInt();
                // System.out.println(storePrice.Search(price).toStringg());

                if (storePrice.searchLessThan(price) == storeDate.search(date)) {
                    //  System.out.println(storeDate.search(date));
                    storeDate.search(date).toStringg();
                   }
                }  System.out.println();
            }


            if (option == 8) {
                FileWriter myWriter = new FileWriter("flights.txt");
                myWriter.write(linkedListForFlights.print());
                myWriter.close();
            }


        }

    }
}

