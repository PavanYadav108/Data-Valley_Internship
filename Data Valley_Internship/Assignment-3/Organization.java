import java.io.*;
import java.lang.*;
import java.util.*;

class Organization{
  int organizationCode;
  String organizationName;
  String organizationAddress;

  Organization(int oC, String oN, String oA){
    organizationCode = oC;
    organizationName = oN;
    organizationAddress = oA;
  }
  void display(){
    System.out.println("Organation Code : "+organizationCode+"\nOrganization Name : "+organizationName+"\nOrganization Address : "+organizationAddress+"\n");
  }

  public static void main(String args[])
  {
    Organization obj = new Organization(1, "Abc", "1-2, Guntur, India");
    obj.display();
    Organization obj1 = new Organization(2, "Xyz", "5/6, Visakhapatnam, India");
    obj1.display();
  }
}


/*Output :-
javac Organization.java
java Organization
Organation Code : 1
Organization Name : Abc
Organization Address : 1-2, Guntur, India

Organation Code : 2
Organization Name : Xyz
Organization Address : 5/6, Visakhapatnam, India
*/