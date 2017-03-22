import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("83ceeaec-c4c5-4e7a-bd59-0678c1426f66")
public class Store {
    @objid ("98e753eb-7e4f-4bca-bf15-7ce5f9f502a7")
    private static Store singleton;

    @objid ("5809a594-176f-479c-bb8b-1865a2492854")
    public Customer[] customers;

    @objid ("34d820f6-f9d5-478f-9477-75ebcb049403")
    private String Connection;

    @objid ("4af12482-93b8-46f2-b96e-bee51a8b2dc7")
    public List<Customer> customers = new ArrayList<Customer> ();

    @objid ("049f0fd5-f9d6-4778-8409-8d936c37ec33")
    public List<Produs> produs = new ArrayList<Produs> ();

    @objid ("18b11b08-a6e0-468a-87b9-4282740bb581")
    public static void getInstance() {
        if (singleton == null) singleton = new Store ();
        return singleton;
    }

    @objid ("4d37acd8-3743-434b-9c62-a688ad24c99d")
    public void registerProduct(Produs p) {
    }

    @objid ("938e1d7a-e352-4def-992e-4741bf2f6be4")
    public void serveCustomer(Customer c) {
    }

    @objid ("7ffe9c43-07c1-49c1-b122-f8a251fc4bea")
    private Store() {
    }

    @objid ("c74af01d-79be-4eb9-9c18-3c33f4cba795")
    String getConnection() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Connection;
    }

    @objid ("ce38e43c-4325-47dd-af53-59239bb87bd4")
    void setConnection(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Connection = value;
    }

}
