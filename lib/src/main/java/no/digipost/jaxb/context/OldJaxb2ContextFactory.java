package no.digipost.jaxb.context;
/*
 * Copyright (C) Posten Norge AS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBContextFactory;
import javax.xml.bind.JAXBException;

import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class OldJaxb2ContextFactory implements JAXBContextFactory {

    private static final Logger LOG = Logger.getLogger(OldJaxb2ContextFactory.class.getName());
    private final JAXBContextFactory delegate = new com.sun.xml.bind.v2.JAXBContextFactory();

    @Override
    public JAXBContext createContext(Class<?>[] classesToBeBound, Map<String, ?> properties) throws JAXBException {
        JAXBContext jaxbContext = delegate.createContext(classesToBeBound, properties);
        LOG.info("Creating new JAXB context of type " + jaxbContext.getClass().getName() +
                " for classes " + Stream.of(classesToBeBound).map(Class::getSimpleName).collect(joining(", ", "[", "]")));
        return jaxbContext;
    }

    @Override
    public JAXBContext createContext(String contextPath, ClassLoader classLoader, Map<String, ?> properties) throws JAXBException {
        JAXBContext jaxbContext = delegate.createContext(contextPath, classLoader, properties);
        LOG.info("Creating new JAXB context of type " + jaxbContext.getClass().getName() +
                " for contextPath " + contextPath);
        return jaxbContext;
    }

}
