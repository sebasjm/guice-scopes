
package com.google.inject.contexts;

import com.google.inject.Key;
import java.util.Map;

/**
 * Este contexto esta basado en el tiempo de vida de la transaccion en curso.
 * TODO: De no existir transaccion, deberia crearla?
 * 
 * @author sebasjm at computer dot org
 */
public class JTAContext implements ContextManager{

    public void begin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void end() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Map<Key, Object> get() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
