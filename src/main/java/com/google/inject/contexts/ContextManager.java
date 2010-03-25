
package com.google.inject.contexts;

import com.google.inject.Key;
import com.google.inject.Provider;
import java.util.Map;

/**
 * Componente encargado de proveer un contexto donde un scope
 * mantendra sus variables
 *
 *
 * @author sebasjm at computer dot org
 */
public interface ContextManager extends Provider<Map<Key,Object>> {

}
