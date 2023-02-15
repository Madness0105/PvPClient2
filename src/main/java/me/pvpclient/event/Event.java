package me.pvpclient.event;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Event {

    public Event call() {
        final ArrayList<EventData> dataList = EventManager.get(this.getClass());

        if(dataList != null){
            for(EventData data : dataList){
                try {
                    data.target.invoke(data.source, this);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return this;
    }

}
