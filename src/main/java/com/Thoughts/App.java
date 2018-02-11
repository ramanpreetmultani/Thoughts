package com.Thoughts;

import com.Thoughts.resources.ThoughtController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class App extends Application<Configuration>
{
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        System.out.println("Registering REST resources");
        e.jersey().register(new ThoughtController());

    }
    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }
}
