package com.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
public class RetriveData extends TestClass implements Comparable<RetriveData> 
{
static Scanner sc=new Scanner(System.in);
int studentId;
String studentName;
int studentScore;
public RetriveData(int studentId, String studentName, int studentScore )
{
this.studentId = studentId;
this.studentName = studentName;
this.studentScore = studentScore;
}
@Override
public String toString()
{
return "Student Data [id=" + studentId + ", name=" + studentName + ", score=" 
+ studentScore + "]";
}
@Override
public int compareTo(RetriveData data)
{
if(studentScore<data.studentScore)
return 1;
else if(studentScore>data.studentScore)
return -1;
else
return 0;
}
public static void getScore() {
int v;
System.out.println("Enter student id to see marks");
v=sc.nextInt();
Set<Integer>sm=map1.keySet();
 for( int i:sm)
 {
 System.out.println();
int marks=map1.get(v);
 
System.out.println("Marks of student id:"+v + "are" + marks);
 }}
 static LinkedHashMap<Integer,Integer> map1=new LinkedHashMap<Integer,Integer>();
 
public static void main(String[]args)
{
PreparedStatement ps=null;
ConnectionTest connectionTest=new ConnectionTest();
Connection connection = connectionTest.getConnectionDetails();
ArrayList<RetriveData >list=new ArrayList<RetriveData >();
try 
{
ps=connection.prepareStatement("select * from student_details");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
int studentId=rs.getInt(1);
 String studentName=rs.getString(2);
 int studentScore=rs.getInt(3);
list.add(new RetriveData(studentId,studentName,studentScore));
map1.put(studentId,studentScore);
}
System.out.println("for taking test enter 1 \nfor all student data enter 2 \nfor particular student mark enter 3\nplease enter your choice");
int a=sc.nextInt();
if(a<1 || a>3) {
System.out.println("please enter valid option");}
switch(a) {
case 1:{
getTest();
}
break;
case 2:{
Collections.sort(list);
for(RetriveData d:list){
System.out.println(d);
}
}
break;
case 3:{
getScore();
}
}}
catch (SQLException e) {
e.printStackTrace();
}
}
}