package newp;

import java.time.LocalTime;
import java.util.Date;

public class Flight {
    String from, to , carrier;
    int price;
    Date date;
    LocalTime time;
    Flight left;
    Flight right;
    int height ;
    int count;


    Flight(Date date, LocalTime time, String from, String to, String carrier, int price) {
        this.date=date;
        this.time=time;
        this.from=from;
        this.to=to;
        this.carrier=carrier;
        this.price=price;
        this.height=1;
        this.left=null;
        this.right=null;
        this.count=1;

    }

  /*  public String toStringg() {
        return "Date: "+ this.date.getDate() + "/" +this.date.getMonth() +"/" + this.date.getYear() + "\n" +
                "Time: " + this.time.getHour() +":"+ this.time.getMinute() + "\n" +
                "From: " +this.from +  "\n" +
                "To: " + this.to + "\n" +
                "Carrier: " + this.carrier + "\n" +
                "Price: " + this.price+ "TL"+ "\n" ;
    }*/

    public String toStringg() {
        int date=this.date.getMonth();
        int realdate = date+1;
        return this.date.getDate() +"-" +realdate +"-" + this.date.getYear() +" "+this.time.getHour() +":"+ this.time.getMinute()+" "+this.from +" "+this.to+" "+this.carrier+" "+this.price+"\n";
    }


    
}
