package fr.unice.smart_campus.middleware.akka.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import fr.unice.smart_campus.middleware.database.SensorsDataOutputDataAccess;
import org.json.JSONObject;

public class DatabaseAccessActor extends UntypedActor {

    private SensorsDataOutputDataAccess sensorsDataOutputDataAccess;
    private LoggingAdapter loggingAdapter;

    public DatabaseAccessActor() throws Exception {
        this.loggingAdapter = Logging.getLogger(this.context().system(), this);
        sensorsDataOutputDataAccess = new SensorsDataOutputDataAccess();
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            this.loggingAdapter.info(message.toString());
            JSONObject jsonObject = new JSONObject(message.toString());
            String name = jsonObject.getString("n");
            String time = jsonObject.getString("t");
            String value = jsonObject.getString("v");

            sensorsDataOutputDataAccess.saveSensorData(name, time, value);
        }
    }
}