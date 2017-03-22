import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("032d1609-b46f-4239-8152-21e2401e7ba0")
public interface Customer {
    @objid ("5fbb65b8-32fd-4a57-8136-858e1078d528")
    void addToCart(Produs p1);

    @objid ("aab85e19-b4fd-48f3-b19b-2086b9ac747f")
    void removeFromCart(Produs p1);

}
