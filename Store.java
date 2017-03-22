import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("83ceeaec-c4c5-4e7a-bd59-0678c1426f66")
public class Store {
    @objid ("98e753eb-7e4f-4bca-bf15-7ce5f9f502a7")
    private Store singleton;

    @objid ("5809a594-176f-479c-bb8b-1865a2492854")
    public Customers[] customers;

    @objid ("4af12482-93b8-46f2-b96e-bee51a8b2dc7")
    public List<Customers> customers = new ArrayList<Customers> ();

    @objid ("049f0fd5-f9d6-4778-8409-8d936c37ec33")
    public List<Produs> produs = new ArrayList<Produs> ();

    @objid ("18b11b08-a6e0-468a-87b9-4282740bb581")
    public void getInstance() {
    }

    @objid ("4d37acd8-3743-434b-9c62-a688ad24c99d")
    public void registerProduct(Produs p) {
    }

}
