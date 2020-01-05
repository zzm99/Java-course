import java.awt.*;
import javax.swing.*;
public class WySpecialtyProxy
{
    public static void main(String[] args)
    {
        SgProxy proxy=new SgProxy();
        proxy.display();
    }
}
//subject ��Specialty
interface Specialty
{
    void display();
}
//realSubject��WySpecialty
class WySpecialty extends JFrame implements Specialty
{
    private static final long serialVersionUID=1L;
    public WySpecialty()
    {
        super("SgProxt WySpecialty Test");
        this.setLayout(new GridLayout(1,1));
        JLabel l1=new JLabel(new ImageIcon("WuyuanSpecialty.jpg"));
        this.add(l1);   
        this.pack();       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    }
    public void display()
    {
        this.setVisible(true);
    }
}
//Proxy: SgProxy
class SgProxy implements Specialty
{
    private WySpecialty realSubject=new WySpecialty();
    public void display()
    {
        preRequest();
        realSubject.display();
        postRequest();
    }
    public void preRequest()
    {
          System.out.println("SgProxy WyProxy starts");
    }
    public void postRequest()
    {
          System.out.println("SgProxy WyProxy ends");
    }
}