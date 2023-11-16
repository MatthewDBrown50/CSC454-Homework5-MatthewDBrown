package CSC454_Homework5_MatthewDBrown.Event;

import CSC454_Homework5_MatthewDBrown.Model.Machine;

import java.util.ArrayList;
import java.util.List;

public class EventQueue
{
    private final List<Event> queue;

    public EventQueue() {
        queue = new ArrayList<>();
    }

    public void scheduleExternalEvent(int numParts, double r, Machine machine) {
        Event newEvent;

        for(int i = 0; i < queue.size(); i++){
            Event existingEvent = queue.get(i);

            if(existingEvent.getR() == r){
                if(existingEvent.getType().equals("internal")){
                    if(existingEvent.getMachine() == machine){
                        newEvent = new ConfluentEvent(numParts, r, machine);
                        queue.set(i, newEvent);
                    }
                    else{
                        newEvent = new ExternalEvent(numParts, r, machine);
                        queue.add(i, newEvent);
                    }
                }
                else{
                    newEvent = new ExternalEvent(numParts, r, machine);
                    queue.add(i, newEvent);
                }

                return;
            }
            else if(existingEvent.getR() < r){
                newEvent = new ExternalEvent(numParts, r, machine);
                queue.add(i, newEvent);

                return;
            }
        }

        newEvent = new ExternalEvent(numParts, r, machine);
        queue.add(newEvent);
    }

    public ArrayList<Event> getNextEvents() {
        if(queue.isEmpty()){
            return null;
        }

        ArrayList<Event> events = new ArrayList<>();

        double r = queue.get(0).getR();
        double nextR = r;

        while(nextR == r){
            events.add(queue.get(0));
            queue.remove(0);

            nextR = queue.isEmpty() ? -1.0 : queue.get(0).getR();
        }

        return events;
    }

    public double timeAdvance(){
        return queue.get(0).getR();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
