package CSC454_Homework5_MatthewDBrown.Event;

import CSC454_Homework5_MatthewDBrown.Model.Machine;

public class ExternalEvent extends Event
{
    public ExternalEvent(int numParts, double r, Machine machine)
    {
        super(numParts, r, machine, "external");
    }
}
