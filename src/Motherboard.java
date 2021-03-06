/**
 * Created by students UA:FTI-EI De Laet Jan & Yigit Yunus Emre.
 */

public class Motherboard extends Component
{
    private String wattUsage;
    private String socket;
    private String ramSlots;
    private String maxRam;
    private String ramType;

    public Motherboard(String groupComponent, String nameComponent, String brandComponent, String wattUsage, String otherDetails, String socket, String ramSlots, String maxRam, String ramType)
    {
        super(groupComponent, nameComponent, brandComponent, otherDetails);
        this.wattUsage = wattUsage;
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

    public String getWattUsage()
    {
        return wattUsage;
    }

    String getSocketMB()
    {
        return socket;
    }

    String getRAMSlots()
    {
        return ramSlots;
    }

    String getMaxRAM()
    {
        return maxRam;
    }

    String getRamType()
    {
        return ramType;
    }

    public String toString()
    {
        return super.toString() + "\nWatt Usage: " + wattUsage + " Watt\nSocket: " + socket + "\nRAM Slots: " + ramSlots + "\nMax Amount of RAM: " + maxRam + " GB\nType of RAM: " + ramType + "\n";
    }
}
