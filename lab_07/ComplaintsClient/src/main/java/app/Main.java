/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sky
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        String all = client.target("http://localhost:8080/Complaints/" + "resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("All complaints:\n" + all);

        String oneOpen = client.target("http://localhost:8080/Complaints/" + "resources/complaints/402")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("One open complaint:\n" + oneOpen);

        String responseEdit = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints/402")
                .request().put(Entity.json(
                        "{\n"
                        + "    \"author\": \"Marvin Doherty\",\n"
                        + "    \"complaintDate\": \"2021-04-23\",\n"
                        + "    \"complaintText\": \"Please fix a tap in room 234\",\n"
                        + "    \"id\": 402,\n"
                        + "    \"status\": \"closed\"\n"
                        + "}"),
                        String.class);
        System.out.println("Edit response:\n" + responseEdit);

        String allOpen = client.target("http://localhost:8080/Complaints/" + "resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("All complaints:\n" + allOpen);

        client.close();
    }

}
