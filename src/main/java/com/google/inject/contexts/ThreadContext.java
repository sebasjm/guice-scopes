package com.google.inject.contexts;

import com.google.inject.Key;
import com.google.inject.Provider;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Este contexto esta basado en el tiempo de vida de cada thread,
 * el cual se inicia y se destruye automaticamente
 * 
 * @author sebasjm at computer dot org
 */
public class ThreadContext implements Provider<Map<Key,Object>> {

    private static ThreadLocal<Map<Key, Object>> locals = new ThreadLocal<Map<Key, Object>>() {

        @Override
        protected Map<Key, Object> initialValue() {
            return new WeakHashMap<Key, Object>();
        }
    };


    public ThreadContext() {
    }

    public Map<Key, Object> get() {
        return locals.get();
    }

}
