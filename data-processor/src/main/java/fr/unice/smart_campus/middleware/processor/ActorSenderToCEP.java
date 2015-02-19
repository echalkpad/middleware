package fr.unice.smart_campus.middleware.processor;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;

import javax.jms.TextMessage;

public class ActorSenderToCEP extends UntypedActor{
    private LoggingAdapter loggingAdapter;

    public ActorSenderToCEP() {
        this.loggingAdapter = Logging.getLogger(this.context().system(), this);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            this.sendEventToCEPEngine((String)message);
        }
    }

    /**
     * Creation of the actor that has to send an event
     * to the CEP Engine to allowed the process the data.
     * @param messageToSend
     */
    private void sendEventToCEPEngine(String messageToSend){
        this.loggingAdapter.info("Send event to CEP Interface Actor : " + messageToSend);
        ActorSelection actorSelection = this.getContext().actorSelection("akka.tcp://Simulation@localhost:2553/user/CEPInterfaceActor");
        actorSelection.tell(messageToSend, this.sender());
    }
//
//    public static void main(String[] args) {
//        ActorSystem actorSystem = ActorSystem.create("ActorSystemFactoryMessageProcessing", ConfigFactory.load());
//        ActorRef actorRef = actorSystem.actorOf(Props.create(ActorSenderToCEP.class), "ActorSenderToCEP");
//        actorRef.tell("{\"n\":\"testAkkaActor\", \"v\":\"12\", \"t\":\"12343\"}", ActorRef.noSender());
//    }
}