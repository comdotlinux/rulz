package com.airhacks.rulz.em;

/*
 * #%L
 * em
 * %%
 * Copyright (C) 2015 Adam Bien
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import static com.airhacks.rulz.em.EntityManagerProvider.persistenceUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import static org.junit.Assert.assertNotNull;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class WorkshopTest {

    @Rule
    public EntityManagerProvider emProvider = persistenceUnit("it-em-rulz");

    @Test
    public void crud() {
        EntityManager em = emProvider.em();
        assertNotNull(em);
        EntityTransaction tx = emProvider.tx();
        assertNotNull(tx);
        tx.begin();
        em.merge(new Workshop("html5", "html5 for javaee developers"));
        tx.commit();
    }
}
