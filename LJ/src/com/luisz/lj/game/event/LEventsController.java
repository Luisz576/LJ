package com.luisz.lj.game.event;

import com.luisz.lj.game.event.listener.LEventListener;
import com.luisz.lj.utils.acessor.Acessor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LEventsController {
    private final List<LEventListener> listeners = new ArrayList<>();

    public final void addListener(LEventListener listener) {
        this.listeners.add(listener);
    }

    public final void removeListener(LEventListener listener) {
        this.listeners.remove(listener);
    }

    public final boolean hasListener(LEventListener listener) {
        return this.listeners.contains(listener);
    }

    public final void callEvent(LEvent event) {
        if (event == null){
            return;
        }
        for (LEventListener listener : this.listeners) {
            Acessor acessor = new Acessor(listener);
            for (Method method : acessor.getDeclaredMethodsWithAnnotation(LEventHandler.class)) {
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0] == event.getClass()){
                    try {
                        method.invoke(listener, event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}