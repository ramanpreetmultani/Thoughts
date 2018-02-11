package com.Thoughts.resources;



import com.Thoughts.api.Thought;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Path("/thought")
@Produces(MediaType.APPLICATION_JSON)
public class ThoughtController {


    @GET
    @Path("/getThought")
    public Response fetchThought(){
        String thought = "hjgyhj";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Thoughts.txt"))));
            List<String> thoughts = new ArrayList<String>();

            while((thought=br.readLine())!=null){
                thoughts.add(thought);
            }
            Random rand = new Random();
            int i = rand.nextInt(thoughts.size());
           
            String thoughtWithAuthor[] = thoughts.get(i).split("-");

            if(thoughtWithAuthor.length==2){
                return Response.ok(new Thought(thoughtWithAuthor[1],thoughtWithAuthor[0]),MediaType.APPLICATION_JSON).build();
            }
            if(thoughtWithAuthor.length==1){
                return Response.ok(new Thought(null,thoughtWithAuthor[0]),MediaType.APPLICATION_JSON).build();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return Response.ok(thought,MediaType.TEXT_PLAIN).build();
    }
}
