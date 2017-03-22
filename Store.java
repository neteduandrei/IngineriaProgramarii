package ip.lab5;

import java.util.ArrayList;
import java.util.List;

public class Store
{
  private static Store singleton;
  private String Connection;
  public List<Customer> customers = new ArrayList();
  public List<Produs> produs = new ArrayList();
  
  public static Store getInstance()
  {
    if (singleton == null) {
      singleton = new Store();
    }
    return singleton;
  }
  
  public void registerProduct(Produs p) {}
  
  public void serveCustomer(Customer c) {}
  
  String getConnection()
  {
    return this.Connection;
  }
  
  void setConnection(String value)
  {
    this.Connection = value;
  }
}
