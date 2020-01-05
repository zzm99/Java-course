public class ProxyTest
{
    public static void main(String[] args)
    {
        Proxy proxy=new Proxy();
        proxy.Request();
    }
}
//abstract subject
interface Subject
{
    void Request();
}
//RealSubject
class RealSubject implements Subject
{
    public void Request()
    {
        System.out.println("Access realSubject method");
    }
}
//proxy
class Proxy implements Subject
{
    private RealSubject realSubject;
    public void Request()
    {
        if (realSubject==null)
        {
            realSubject=new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("preRequest");
    }
    public void postRequest()
    {
        System.out.println("postRequest");
    }
}