
package com.google.inject.contexts;

import com.google.inject.ImplementedBy;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.scopes.annotations.CustomScope;
import java.util.Map;

/**
 * Componente encargado de proveer un contexto donde un scope
 * mantendra sus variables
 *
 *
 * @author sebasjm at computer dot org
 */
@ImplementedBy(ContextManagerProvider.class)
public interface ContextManager {

    public Provider<Map<Key, Object>> get(CustomScope annotation);

}
