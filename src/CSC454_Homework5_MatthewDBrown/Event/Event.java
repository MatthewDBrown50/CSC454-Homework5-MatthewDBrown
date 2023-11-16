package CSC454_Homework5_MatthewDBrown.Event;

import CSC454_Homework5_MatthewDBrown.Model.Machine;

public class Event
{
    private final double r;
    private final Machine machine;
    private final int numParts;
    private final String type;

    public Event(int numParts, double r, Machine machine, String type)
    {
        this.numParts = numParts;
        this.r = r;
        this.machine = machine;
        this.type = type;
    }

    public double getR()
    {
        return r;
    }

    public Machine getMachine()
    {
        return machine;
    }

    public int getNumParts()
    {
        return numParts;
    }

    public String getType()
    {
        return type;
    }

}
