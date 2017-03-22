import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b9618113-c512-4635-815f-6b2a0f6c5375")
public class Buchet implements Produs {
    @objid ("87e04691-cf66-4bc2-a8e7-16c2e935aea4")
    private Floare[] flori;

    @objid ("60835a4b-d346-44f9-be22-8b1313c89d0a")
    public void getPrice() {
    }

    @objid ("76aac81f-475a-453f-8e1f-76b821020e33")
    Floare[] getFlori() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.flori;
    }

    @objid ("282ea408-604b-4d82-bd37-4488715eed4d")
    void setFlori(Floare[] value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.flori = value;
    }

}
