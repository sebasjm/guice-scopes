package com.google.inject.scopes;

import com.google.inject.modules.ScopesExtensionModule;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.modules.ScopeModule;
import org.junit.Ignore;

/**
 * TODO: generar una transaccion para hacer pruebas
 * @author sebasjm at computer dot org
 */
@Ignore
public class JTAScopeTest {

    private Injector injector;

    @Before
    public void creteInjector() {
        injector = Guice.createInjector(
                Stage.DEVELOPMENT,
                new ScopeModule()
            );
        injector = Guice.createInjector(
                Stage.DEVELOPMENT,
                injector.getInstance(ScopesExtensionModule.class),
                new DummyModule()
            );
    }

    @Test
    public void should_retrieve_from_injector() {
    }

    @Test
    public void should_retrieve_different_same_instance() {
    }

    @Test
    public void should_retrive_different_instance() throws Exception {
    }

    private DummyInJTAContext retrieveIntance() {
        return injector.getInstance(DummyInJTAContext.class);
    }

    private class Retriever implements Runnable {

        private DummyInJTAContext dummy;

        public void run() {
            dummy = retrieveIntance();
        }
    }
}
