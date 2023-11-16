package CSC454_Homework5_MatthewDBrown.Event;

import CSC454_Homework5_MatthewDBrown.Model.Machine;

public class InternalEvent extends Event
{
    public InternalEvent(int numParts, double r, Machine machine)
    {
        super(numParts, r, machine, "internal");
    }
}
