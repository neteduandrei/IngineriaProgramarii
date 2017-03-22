import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("11c945a2-be09-4f6f-bb70-42095f4ace77")
public class Cos {
    @objid ("cd6c3fef-2730-4c57-8602-917bfb6d7941")
    private Produs[] ListaProduse;

    @objid ("3a55bc6d-b627-41bd-a8a4-3b77dc1e9461")
    public List<Produs> produs = new ArrayList<Produs> ();

    @objid ("6d024540-8911-446a-8eb4-07f2f1ed5967")
    public void addProduct(Produs p1) {
    }

    @objid ("7ef72945-5790-432a-a2b9-834e15c17930")
    public void removeProdus(Produs p1) {
    }

    @objid ("5be6b7b8-4600-43f5-a2ca-d3fe067e8598")
    Produs[] getListaProduse() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.ListaProduse;
    }

    @objid ("71874f90-34ea-49e1-a7a0-9cdb60c3922b")
    void setListaProduse(Produs[] value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.ListaProduse = value;
    }

}
