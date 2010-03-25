package com.google.inject.scopes;

import com.google.inject.Inject;
import com.google.inject.contexts.ContextManager;
import com.google.inject.Key;
import com.google.inject.Provider;
import java.util.Map;

/**
 * Scope basado en http://github.com/fabriciotuosto/guice-scopes
 * @author sebasjm at computer dot org
 */
public class ContextBasedScope implements ExtendedScope {

    private ContextManager contextManager;

    @Inject
    public ContextBasedScope(ContextManager contextManager) {
        this.contextManager = contextManager;
    }

    /**
     * Thread Local scope.
     */
    public <T> Provider<T> scope(final Key<T> key, final Provider<T> creator) {
        return new Provider<T>() {

            public T get() {
                Map<Key, Object> context = contextManager.get();
                if(!context.containsKey(key)){
                    context.put(key,creator.get());
                }
                return (T) context.get(key);
            }
        };
    }
}
