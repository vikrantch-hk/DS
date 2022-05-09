public class Hacker{
public void doIt(int i , Men p){
i = 5;
p.number = 8;
}

public static void main(String [] args) 
{
	Hacker p = new Hacker();
    p.start();
}

void start() 
{
    boolean b1 = false;
    boolean b2 = fix(b1);
    System.out.println(b1 + " " + b2);
}

boolean fix(boolean b1) 
{
    b1 = true;
    return b1;
}
}

class Men { public int number; }