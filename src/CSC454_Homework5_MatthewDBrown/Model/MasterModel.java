package CSC454_Homework5_MatthewDBrown.Model;

public abstract class MasterModel
{
    public abstract double timeAdvance();
    public abstract int lambda();
    public abstract void deltaInternal();
    public abstract void deltaExternal(int numParts, double timeElapsed);
    public abstract void deltaConfluent(int numParts);
}
