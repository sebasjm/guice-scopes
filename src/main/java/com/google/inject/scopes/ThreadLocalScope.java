package com.google.inject.scopes;


import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import java.util.HashMap;
import java.util.Map;

public class ThreadLocalScope implements Scope {

    private ThreadLocal<Map<Key<?>, Object>> thread_context = new ThreadLocal<Map<Key<?>, Object>>() {

        @Override
        protected synchronized Map<Key<?>, Object> initialValue() {
            return new HashMap<Key<?>, Object>();
        }

    };

    /**
     * Thread Local scope.
     */
    public static final Scope THREAD_LOCAL = new ThreadLocalScope();

    public <T> Provider<T> scope(final Key<T> key, final Provider<T> creator) {
        return new Provider<T>() {

            @SuppressWarnings("unchecked")
            public T get() {
                Map<Key<?>, Object> context = thread_context.get();

                if ( !context.containsKey(key) ) {
                    context.put(key, creator.get());
                }
                return (T) context.get(key);
            }
        };
    }
}
