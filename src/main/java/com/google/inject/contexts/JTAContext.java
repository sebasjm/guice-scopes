
package com.google.inject.contexts;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.transaction.Transaction;

/**
 * Este contexto esta basado en el tiempo de vida de la transaccion en curso.
 * TODO: De no existir transaccion, deberia crearla?
 * 
 * @author sebasjm at computer dot org
 */
public class JTAContext implements Provider<Map<Key,Object>> {

    private static Map<Transaction,Map<Key,Object>> locals = new ConcurrentHashMap<Transaction, Map<Key, Object>>();
    private Injector injector;

    @Inject
    public JTAContext(Injector injector) {
        this.injector = injector;
    }

    public Map<Key, Object> get() {
        return locals.get(injector.getInstance(Transaction.class));
    }

}
