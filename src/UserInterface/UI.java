/*
 * Project: ARUBA 
 * Class:   Main
 *
 * Version info
 * Created: 5/10/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package UserInterface;

import com.ARUBAExceptions.ModeOfTransportException;
import com.ARUBAExceptions.NoAgentsException;
import com.ARUBAExceptions.NoAssignmentsException;
import com.ARUBAExceptions.NoResultsException;
import com.*;
import com.GoogleAPI.DirectionsGoogle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class UI {

    public UI() {
        JFrame guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example UI for ARUBA");
        guiFrame.setSize(700,600);
        guiFrame.setLocationRelativeTo(null);

        String [] vegOptions = {"Asparagus", "Beans", "Broccoli", "Cabbage",
                                "Carrot", "Celery", "Cucumber", "Leek",
                                "Mushroom", "Pepper", "Radish", "Shallot",
                                "Spinach", "Swede", "Turnip"};

        final JPanel listPanel = new JPanel();
        listPanel.setVisible(false);
        JLabel listLbl = new JLabel("Sorted list based on fastest traveltime: ");
        JList vegs = new JList(vegOptions);
        vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        listPanel.add(listLbl);
        listPanel.add(vegs);

        JButton arubaResultsButton = new JButton("Show ARUBA results");
        JButton addNewAgent = new JButton("Add new agent");
        JButton addNewAssignment = new JButton("Add new assignment");
        JButton arubaButton = new JButton("ARUBA");

        List<Agent> agents = new ArrayList<>();
        final int[] identifier = {0};
        addNewAgent.addActionListener(e -> {
            String firstName = JOptionPane.showInputDialog(null, "Enter the agents first name");
            System.out.println("First name: " + firstName);

            String lastName = JOptionPane.showInputDialog(null, "Enter the agents last name");
            System.out.println("Last name: " + lastName);

            String zip = JOptionPane.showInputDialog(null, "Enter the agents zip location");
            System.out.println("Zip: " + zip);
            identifier[0]++;
            Agent newAgent = new Agent(new Position(), "" + identifier[0] + "", firstName, lastName);
            newAgent.getPosition().setZip(zip);
            agents.add(newAgent);
        });

        List<Assignment> assignments = new ArrayList<>();
        addNewAssignment.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(null, "Enter the assignment id");
            System.out.println("ID: " + id);

            String zip = JOptionPane.showInputDialog(null, "Enter the assignments zip location");
            System.out.println("Zip: " + zip);

            Assignment newAssignment = new Assignment(new Position(), id);
            newAssignment.getPosition().setZip(zip);
            assignments.add(newAssignment);
        });

        String graphhopperKey = "7992858f-c567-4ae8-b47c-f409b65f91f4";
        String googleKey = "AIzaSyC3SJNwOjapbbdwGZlanF1mC83UGEbWH7s";
        String mapboxKey = "pk.eyJ1IjoiZGVlYXdlc29tZW9uZSIsImEiOiJjajBudG5mMm0wMDBjMzNvYjN3ZGp2YnBkIn0.FqRsKggeTeqkszoWixJOcQ";

        Output output = new Output();
        arubaButton.addActionListener(e -> {
            DirectionsGoogle directionsGoogle = new DirectionsGoogle(googleKey);
            List<TravelRoutes> travelRoutes = new ArrayList<>();
            try {
                travelRoutes = directionsGoogle.calculateRoutes(agents, assignments, "car");
            } catch (NoAgentsException noAgentsException) {
                noAgentsException.printStackTrace();
            } catch (NoAssignmentsException e1) {
                e1.printStackTrace();
            } catch (ModeOfTransportException e1) {
                e1.printStackTrace();
            } catch (NoResultsException e1) {
                e1.printStackTrace();
            }

            output.setSortList(travelRoutes);
            listPanel.remove(vegs);

            String [] arubaList = new String[agents.size()];

            for (int i = 0; i < agents.size(); i++) {
                AgentRoute agentRoute = output.getSortList().getAgentRoute(i);
                String agentID = agentRoute.getAgent().getId();
                String firstName = agentRoute.getAgent().getFirstName();
                String surName = agentRoute.getAgent().getSurName();
                long agentTraveltime = agentRoute.getRoute().getTime();
                arubaList[i] = agentID + ": " + firstName + " " + surName + ", traveltime: " + agentTraveltime + "s";
                System.out.println("arubalist[" + i + "]: " + firstName + " " + surName + ", " + arubaList[i]);
            }

            JList arubaResults = new JList(arubaList);
            arubaResults.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            listPanel.add(arubaResults);
        });

        arubaResultsButton.addActionListener(e -> {
            // When the fruit or veg button is pressed
            // the setVisible value of the listPanel and
            // comboPanel is switched from true to value
            // or vice versa.
            listPanel.setVisible(!listPanel.isVisible());
            addNewAgent.setVisible(!addNewAgent.isVisible());
            addNewAssignment.setVisible(!addNewAssignment.isVisible());
            arubaButton.setVisible(!arubaButton.isVisible());
        });

        guiFrame.add(listPanel, BorderLayout.CENTER);
        guiFrame.add(arubaResultsButton, BorderLayout.SOUTH);
        guiFrame.add(addNewAgent, BorderLayout.EAST);
        guiFrame.add(addNewAssignment, BorderLayout.WEST);
        guiFrame.add(arubaButton, BorderLayout.NORTH);

        guiFrame.setVisible(true);
    }

    public static void main(String [] args) {
        System.out.println("752 61".substring(0,2));
        new UI();
    }
}