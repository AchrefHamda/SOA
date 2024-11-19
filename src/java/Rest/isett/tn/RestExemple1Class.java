/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest.isett.tn;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lenovo
 */
@Path("RestExemple1")
public class RestExemple1Class {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestExemple1Class
     */
    public RestExemple1Class() {
    }

    /**
     * Retrieves representation of an instance of Rest.isett.tn.RestExemple1Class
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        return "<Salutation> Bonjour mes étudiants MDW21 </Salutation>";
    }

    /**
     * PUT method for updating or creating an instance of RestExemple1Class
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * Retrieves representation with parameters
     * @param id Path parameter representing an ID
     * @param name Header parameter with a default value
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}") // Définit un chemin dynamique pour capturer l'ID dans l'URL
    @Produces(MediaType.APPLICATION_XML)
    public String getXmlWithParams(
        @PathParam("id") String id, // Récupère l'ID depuis l'URL
        @DefaultValue("tous les enseignants") @HeaderParam("name") String name // Lit le paramètre d'en-tête
    ) {
        System.out.println("ID reçu : " + id); // Affiche l'ID dans la console
        System.out.println("Nom reçu dans l'en-tête : " + name); // Affiche le nom
        return "<Salutation> " + id + " :Bonjour mes étudiants MDW21 de la part de " + name + "</Salutation>";
    }
    
    @GET
@Path("student/{id}")
@Produces("application/xml")
public Etudiant getPerson(@PathParam("id") long id) {
    Etudiant p = new Etudiant();
    p.setId(id);
    p.setNom("Achref");
    p.setPrenom("Hamda");
    p.setAge(23);
    return p;
}

}
