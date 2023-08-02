package com.luisz.lj.game.event;

import com.luisz.lj.game.event.listener.IEventListener;
import com.luisz.lj.utils.acessor.Acessor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LEvents {
    private final List<IEventListener> listeners = new ArrayList<>();

    public final void addListener(IEventListener listener) {
        this.listeners.add(listener);
    }

    public final void removeListener(IEventListener listener) {
        this.listeners.remove(listener);
    }

    public final boolean hasListener(IEventListener listener) {
        return this.listeners.contains(listener);
    }

    public final void callEvent(IEvent event) {
        if (event == null){
            return;
        }
        for (IEventListener listener : this.listeners) {
            Acessor acessor = new Acessor(listener);
            for (Method method : acessor.getDeclaredMethodsWithAnnotation(LEvent.class)) {
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