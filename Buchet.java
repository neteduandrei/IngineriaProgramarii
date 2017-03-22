package ip.lab5;

public class Buchet
  implements Produs
{
  private Floare[] flori;
  
  public void getPrice() {}
  
  Floare[] getFlori()
  {
    return this.flori;
  }
  
  void setFlori(Floare[] value)
  {
    this.flori = value;
  }
}
