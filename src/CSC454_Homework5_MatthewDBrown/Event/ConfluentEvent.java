package CSC454_Homework5_MatthewDBrown.Event;

import CSC454_Homework5_MatthewDBrown.Model.Machine;

public class ConfluentEvent extends Event
{
    public ConfluentEvent(int numParts, double r, Machine machine)
    {
        super(numParts, r, machine, "confluent");
    }
}
