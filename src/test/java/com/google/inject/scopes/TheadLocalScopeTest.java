package com.google.inject.scopes;

import com.google.inject.modules.ScopeModule;
import com.google.inject.modules.ScopesExtensionModule;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

public class TheadLocalScopeTest {

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
        assertNotNull(retrieveIntance());
    }

    @Test
    public void should_retrieve_different_same_instance() {
        assertSame(retrieveIntance(), retrieveIntance());
    }

    @Test
    public void should_retrive_different_instance() throws Exception {
        Retriever retriever = new Retriever();
        Thread thread = new Thread(retriever);
        thread.start();
        thread.join();
        assertNotSame(retriever.dummy, retrieveIntance());
    }

    private DummyInThreadContext retrieveIntance() {
        return injector.getInstance(DummyInThreadContext.class);
    }

    private class Retriever implements Runnable {

        private DummyInThreadContext dummy;

        public void run() {
            dummy = retrieveIntance();
        }
    }
}
