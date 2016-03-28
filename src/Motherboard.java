/**
 * Created by students UA:FTI-EI De Laet Jan & Yigit Yunus Emre.
 */

public class Motherboard extends Component
{
    private String socket;
    private String ramSlots;
    private String maxRam;
    private String ramType;

    public Motherboard(String groupComponent, String nameComponent, String brandComponent, String otherDetails, String socket, String ramSlots, String maxRam, String ramType)
    {
        super(groupComponent, nameComponent, brandComponent, otherDetails);
        this.socket = socket;
        this.ramSlots = ramSlots;
        this.maxRam = maxRam;
        this.ramType = ramType;
    }

    public String getGroupComponent()
    {
        return super.getGroupComponent();
    }

    public String getNameComponent()
    {
        return super.getNameComponent();
    }

    public String getBrandComponent()
    {
        return super.getBrandComponent();
    }

    public String getOtherDetails()
    {
        return socket + "\n" + ramSlots + "\n" + maxRam + "\n" + ramType + "\n" + super.getOtherDetails();
    }

}
