package CSC454_Homework5_MatthewDBrown.Network;

import CSC454_Homework5_MatthewDBrown.Event.Event;
import CSC454_Homework5_MatthewDBrown.Event.EventQueue;
import CSC454_Homework5_MatthewDBrown.Model.Drill;
import CSC454_Homework5_MatthewDBrown.Model.Press;

import java.util.ArrayList;

public class Network
{
    private final Press press;
    private final Drill drill;
    private int pressOutput;
    private int drillOutput;
    private final EventQueue queue;
    private double r;

    public Network()
    {
        this.press = new Press();
        this.drill = new Drill();
        this.pressOutput = 0;
        this.drillOutput = 0;
        this.queue = new EventQueue();
    }

    public void addParts(int numParts, double timeAdded){
        queue.scheduleExternalEvent(numParts, timeAdded, press);
    }

    public String simulate(){
        ArrayList<Event> events;

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            events = queue.getNextEvents();

            for (Event event: events)
            {
                if(!event.getType().equals("external")){
                    int output = event.getMachine().lambda();

                    if(event.getMachine() == press){
                        pressOutput = output;
                    }
                    else{
                        drillOutput = output;

                        if(drillOutput > 0){
                            sb.append("Finished processing ").append(drillOutput).append(" part(s) at ").append(this.r);
                        }
                    }
                }
            }

            if(pressOutput > 0){
                queue.scheduleExternalEvent(pressOutput, r, drill);
            }

            for (Event event: events){
                event.getMachine().setParts(event.getMachine().getParts() + event.getNumParts());
            }

            for (Event event: events){
                switch (event.getType()){
                    case "internal":
                        event.getMachine().deltaInternal();
                        break;
                    case "external":
                        event.getMachine().deltaExternal(event.getNumParts(), event.getR());
                        break;
                    case "confluent":
                        event.getMachine().deltaConfluent(event.getNumParts());
                }
            }

            r = queue.timeAdvance();
        }

        return sb.toString();
    }
}
