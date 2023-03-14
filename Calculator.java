import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.LinkedList;

public class Calculator extends JFrame implements ActionListener {
  static  JButton oneNum,two,threeNum,fourNum,fiveNum,sixNum,sevenNum,eightNum,nineNum,clear,zeroNum,equal,add,sub,mul,div;
   static JTextField field;
   static int begin=0;
   static String ans;
 static    LinkedList<Integer> l=new LinkedList<Integer>();
 static   LinkedList<Character> c=new LinkedList<Character>();
    Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field = new JTextField();
        field.setBounds(10,10, 280,40);
        field.setBackground(new Color(255,255,255));
        this.add(field);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        panel.setBounds(10,60,280,300);
        panel.setBackground(Color.orange);

        this.add(panel);

        oneNum = new JButton("1");
         two = new JButton("2");
         threeNum = new JButton("3");
        clear = new JButton("C");
         fourNum = new JButton("4");
         fiveNum = new JButton("5");
        sixNum = new JButton("6");
         sevenNum = new JButton("7");
         eightNum = new JButton("8");
     nineNum = new JButton("9");
        zeroNum = new JButton("0");
        equal=new JButton("=");

         add = new JButton("+");
         sub = new JButton("-");
         mul = new JButton("*");
       div = new JButton("/");
        panel.add(oneNum);
        panel.add(two);
        panel.add(threeNum);
        panel.add(add);
        panel.add(fourNum);
        panel.add(fiveNum);
        panel.add(sixNum);
        panel.add(sub);
        panel.add(sevenNum);
        panel.add(eightNum);
        panel.add(nineNum);
        panel.add(mul);
        panel.add(clear);
        panel.add(zeroNum);
        panel.add(equal);
        panel.add(div);
        setSize(310,400);
        setLayout(null);
        setVisible(true);

        oneNum.addActionListener(this);
        two.addActionListener(this);
        threeNum.addActionListener(this);
        fourNum.addActionListener(this);
        fiveNum.addActionListener(this);
        sixNum.addActionListener(this);
        sevenNum.addActionListener(this);
        eightNum.addActionListener(this);
        nineNum.addActionListener(this);
        zeroNum.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);
        equal.addActionListener(this);


    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        if (e.getSource() == oneNum){
            field.setText( field.getText()+oneNum.getText());
        }
        if(e.getSource()==two){
            field.setText(field.getText()+two.getText());
        }
        if(e.getSource()==threeNum){
            field.setText(field.getText()+threeNum.getText());
        }
        if(e.getSource()==fourNum){
            field.setText(field.getText()+fourNum.getText());
        }
        if(e.getSource()==fiveNum){
            field.setText(field.getText()+fiveNum.getText());
        }
        if(e.getSource()==sixNum){
            field.setText(field.getText()+sixNum.getText());
        }
        if(e.getSource()==sevenNum){
            field.setText(field.getText()+sevenNum.getText());
        }
        if(e.getSource()==eightNum){
            field.setText(field.getText()+eightNum.getText());
        }
        if(e.getSource()==nineNum){
            field.setText(field.getText()+nineNum.getText());
        }
        if(e.getSource()==zeroNum){
            field.setText(field.getText()+zeroNum.getText());
        }
        if(e.getSource()==add){
            field.setText(field.getText()+add.getText());
        }
        if(e.getSource()==sub){
            field.setText(field.getText()+sub.getText());
        }
        if(e.getSource()==mul){
            field.setText(field.getText()+mul.getText());
        }
        if(e.getSource()==div){
            field.setText(field.getText()+div.getText());
        }
        if (e.getSource() == clear){
           field.setText("");
        }
        if(e.getSource()==equal){
            System.out.println("equal is pressed !");
            text();
            opration();
        }


    }


  static   void text() {

String temp="";
begin=0;
         temp=field.getText();

        String last="";
        int lastcharindex=0;
        char[] num=temp.toCharArray();//conversion of String to array of char num
      for (Character d:num)
            {
                System.out.println(d);
      }
        char[] sign= {'+','-','*','/'};


        for(int i=begin;i<num.length;i++) {

            for(int j=0;j<sign.length;j++) {
                if(num[i]==sign[j]) {
                    lastcharindex =i;
                    c.add(num[i]);
                    int end=i;
                    String temp1 ="";
                    for(int k=begin;k<end;k++) {
                        temp1 += String.valueOf(num[k]);
                        begin=end+1;

                    }
                    l.add(Integer.valueOf(temp1));

                }
            }

        }
        for(int i=lastcharindex+1;i<num.length;i++) {
            last +=String.valueOf(num[i]);
        }
        l.add(Integer.valueOf(last));
      System.out.println("value entered");


    }
 static    void opration() {
        int j=0;
        int result=l.get(j);
        for(int i=0;i<c.size();i++){
            char cheak=c.get(i);
            switch(cheak)
            {
                case '+':
                    result=result+l.get(j+1);
                    j++;
                    break;

                case '-':
                    result=result-l.get(j+1);
                    j++;
                    break;
                case '*':
                    result=result*l.get(j+1);
                    j++;
                    break;
                case '/':
                    result=result/l.get(j+1);
                    j++;
                    break;
            }

        }
        ans=String.valueOf(result);
        field.setText(ans);
System.out.println("Ans="+ans);
//       for(int i=0;i<l.size();i++){
//           l.remove();
//
//       }
     l.clear();
     System.out.println("linked list value\t"+l.size());
       for(int i:l){
           System.out.println("linked list value\t"+i);
       }
//
     c.clear();
     for(char i:c){
         System.out.println("linked list char  value\t"+i);
     }

    }



    public static void main(String[] args){
        new Calculator();





}
}
