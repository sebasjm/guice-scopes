
package com.google.inject.modules;

import com.google.inject.AbstractModule;
import com.google.inject.scopes.ExtendedScope;
import com.google.inject.scopes.ContextBasedScope;

/**
 *
 * @author sebasjm at computer dot org
 */
public class ScopeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ExtendedScope.class).to(ContextBasedScope.class);
    }

}
