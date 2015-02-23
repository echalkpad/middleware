package fr.unice.smart_campus.middleware.virtual_sensor_processing;

import akka.actor.*;
import akka.dispatch.Dispatchers;
import akka.dispatch.Mailboxes;
import akka.event.EventStream;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import fr.unice.smart_campus.middleware.akka.actor.DatabaseAccessActor;
import groovy.lang.GroovyShell;
import scala.Function0;
import scala.collection.*;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.duration.Duration;

public class Main {
    public static void main(String[] args) {

        String script = new String("double x = ${input};return x*3;");

        GroovyShell shell = new GroovyShell();
        shell.setVariable("input","2");
        String res = shell.evaluate(script).toString();
        System.out.println(res);

        // creation of the actor system (Actor factory)
        //ActorSystem actorSystem = ActorSystem.create("ActorSystemFactory", ConfigFactory.load());
        //actorSystem.actorOf(Props.create(DatabaseAccessActor.class), "DatabaseAccessActor");
    }
}
