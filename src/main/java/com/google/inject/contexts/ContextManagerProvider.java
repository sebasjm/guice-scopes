
package com.google.inject.contexts;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.scopes.annotations.CustomScope;
import java.util.Map;

/**
 *
 * @author sebasjm at computer dot org
 */
public class ContextManagerProvider implements ContextManager {

    private Injector injector;

    @Inject
    public ContextManagerProvider(Injector injector) {
        this.injector = injector;
    }

    public Provider<Map<Key, Object>> get(CustomScope annotation) {
        return (Provider<Map<Key, Object>>) injector.getInstance( annotation.value() );
    }

}
