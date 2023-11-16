package CSC454_Homework5_MatthewDBrown.Model;

public class Machine extends MasterModel
{
    private int parts;
    private double timeRemaining;
    private final int timeToProcess;

    public Machine(int timeToProcess)
    {
        this.timeToProcess = timeToProcess;
    }

    @Override
    public double timeAdvance(){
        return parts > 0 ? timeRemaining : Double.POSITIVE_INFINITY;
    }

    @Override
    public int lambda(){
        return 1;
    }

    @Override
    public void deltaInternal(){
        parts--;
        timeRemaining = timeToProcess;
    }

    @Override
    public void deltaExternal(int numParts, double timeElapsed)
    {
        parts += numParts;

        if(parts > 0){
            timeRemaining -= timeElapsed;
        }
        else {
            timeRemaining = timeToProcess;
        }
    }

    @Override
    public void deltaConfluent(int numParts)
    {
        parts += numParts - 1;
        timeRemaining = 1;
    }

    public int getParts()
    {
        return parts;
    }

    public void setParts(int parts)
    {
        this.parts = parts;
    }
}
