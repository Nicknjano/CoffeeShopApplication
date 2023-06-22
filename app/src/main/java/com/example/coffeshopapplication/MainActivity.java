package com.example.coffeshopapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView numberOfCoffee;
    private TextView bill;
    private Button minus;
    private Button plus;
    public String num;
    public int toNum;
    public int price=120;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfCoffee=findViewById(R.id.numberOfCoffee);
        minus=findViewById(R.id.minus);
        plus=findViewById(R.id.plus);
        bill=findViewById(R.id.bill);
    }

    public void btnMinus(View view){
       num=String.valueOf(numberOfCoffee.getText());
       toNum= Integer.parseInt(num);
       if (toNum>0) {
           toNum = toNum - 1;
           String toText = String.valueOf(toNum);
           numberOfCoffee.setText(toText);
           bill.setText("Your Order is :\n"+numberOfCoffee.getText()+"cups of coffee \nTotal cost = "+(toNum * price));
           Toast.makeText(getApplicationContext(), numberOfCoffee.getText() + " Cups" + "\ntotal price=" + (toNum * price), Toast.LENGTH_LONG).show();

       }
       else
           Toast.makeText(getApplicationContext(), "Can not order less than zero coffees ", Toast.LENGTH_LONG).show();

    }
    public void btnPlus(View view){
        if(toNum<20){

            num=String.valueOf(numberOfCoffee.getText());
            toNum= Integer.parseInt(num);
            toNum=toNum+1;
            String toText= String.valueOf(toNum);
            numberOfCoffee.setText(toText);
            bill.setText("Your Order is :\n"+numberOfCoffee.getText()+"cups of coffee \nTotal cost = "+(toNum * price));
            Toast.makeText(getApplicationContext(),numberOfCoffee.getText()+" Cups" +"\ntotal price="+ (toNum * price),Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(getApplicationContext(), "Can not order more than twenty cups ", Toast.LENGTH_LONG).show();
    }

    public void btnOrder(View view){
        bill.setText("Your Order is :\nItems      Price\n"+numberOfCoffee.getText()+"cups     "+(toNum * price));
    }

}