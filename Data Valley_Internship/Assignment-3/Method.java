class Hello
{
    public void display()
    {
        System.out.println("Hello! Good Morning");
    }
}

class Greet extends Hello
{
    public void greetings()
    {
        System.out.println("Greetings Good Morning");
    }

    public void greetings(String name)
    {
        System.out.println("Greeting to "+name);
    }
}


class Method
{
    public static void main(String args[])
    {
        Hello obj = new Hello();
        obj.display();

        Greet obj1 = new Greet();
        obj1.greetings();
        obj1.greetings("Raghu");
    }
}

/*Output -
javac Method.java
java Method
Hello! Good Morning
Greetings Good Morning
Greeting to Raghu
*/