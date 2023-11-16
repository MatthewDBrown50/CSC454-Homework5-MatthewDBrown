package CSC454_Homework5_MatthewDBrown.Network;

public class Main
{
    public static void main(String[] args) {
        Network network = new Network();
        network.addParts(12, 1.5);
        System.out.println(network.simulate());
    }
}
