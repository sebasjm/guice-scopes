package com.google.inject.scopes;

import com.google.inject.Inject;
import com.google.inject.contexts.ContextManager;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.scopes.annotations.CustomScope;
import java.util.Map;

/**
 * CustomScope basado en http://github.com/fabriciotuosto/guice-scopes
 * @author sebasjm at computer dot org
 */
public class ContextBasedScope implements ExtendedScope {

    private ContextManager contextManager;

    @Inject
    public ContextBasedScope(ContextManager contextManager) {
        this.contextManager = contextManager;
    }

    /**
     * lazy scope.
     */
    public <T> Provider<T> scope(final Key<T> key, final Provider<T> creator) {
        return new Provider<T>() {
            public T get() {
                return (T) createIfDoesntExist(key,creator).get(key);
            }
        };
    }
    
    public Map<Key, Object> createIfDoesntExist(final Key key, final Provider creator) {
        Map<Key, Object> context = getContextBasedOnKey(key);
        if(!context.containsKey(key)){
            context.put(key, creator.get());
        }
        return context;
    }

    public Map<Key, Object> getContextBasedOnKey(Key key) {
        return contextManager.get(
                (CustomScope) key
                    .getTypeLiteral()
                    .getRawType()
                    .getAnnotation(CustomScope.class)
            ).get();
    }
}
