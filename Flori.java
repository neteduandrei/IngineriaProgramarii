import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("212f0283-82dc-40bd-8485-82dfa662554d")
public class Flori implements Produs {
    @objid ("54ca6472-e219-4629-a77f-943735168ef0")
    public int count;

    @objid ("2875400d-9e41-45ef-9c0b-833a0af4363b")
    public List<Buchet> buchet = new ArrayList<Buchet> ();

    @objid ("0e7f20b6-34b1-4368-95d6-e9fce1619e4a")
    public void getPrice() {
    }

    @objid ("0860c655-37cf-4e7b-a38d-716f058208fa")
    public void getCount() {
    }

}
