package tests;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class test_textarea { 
 public static void main (String args[]){
  JFrame f=new JFrame("test");
  f.setBounds(300, 200, 300, 200);
  f.setVisible(true);
  JTextArea t=new JTextArea(100,100);
  String str="";
  for(int i=1;i<=5;i++){
   str+="abcdefgh";
   str+='\n';
  }
  t.append(str);
  f.add(t);

  f.setVisible(true);
 }
}
