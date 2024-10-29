package org.example;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import org.example.configurator.*;
import org.example.ontology.QueryService;
import org.example.ontology.SPARQLQueryExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


// Generation some Test for QueryService
public class QueryServiceTest {
    private SPARQLQueryExecutor queryExecutorMock;
    private QueryService queryService;

    @BeforeEach
    public void setUp() {
        // Crea un mock del SPARQLQueryExecutor
        queryExecutorMock = Mockito.mock(SPARQLQueryExecutor.class);
        // Inietta il mock nel QueryService
        queryService = new QueryService(queryExecutorMock);
    }

    @Test
    public void testGetBatteryComponents() {
        // Crea un ResultSet simulato
        ResultSet mockResultSet = mock(ResultSet.class);
        QuerySolution mockSolution = mock(QuerySolution.class);
        Resource mockResource = mock(Resource.class);
        Literal mockLiteral = mock(Literal.class);

        // Configura il comportamento del mock
        when(mockResultSet.hasNext()).thenReturn(true, false);
        when(mockResultSet.nextSolution()).thenReturn(mockSolution);
        when(mockSolution.getResource("battery")).thenReturn(mockResource);
        when(mockResource.getLocalName()).thenReturn("Battery1");
        when(mockSolution.getLiteral("capacity")).thenReturn(mockLiteral);
        when(mockLiteral.getDouble()).thenReturn(5000.0);

        // Configura l'esecuzione della query
        when(queryExecutorMock.executeQuery(anyString())).thenReturn(mockResultSet);

        // Esegui il metodo da testare
        List<Battery> batteryList = queryService.getBatteryComponents(new Laptop("TestLaptop"));

        // Verifica i risultati
        assertNotNull(batteryList);
        assertEquals(1, batteryList.size());
        assertEquals("Battery1", batteryList.get(0).getBatteryName());
        assertEquals(5000.0, batteryList.get(0).getBatteryCapacity(), 0.01);
    }

    @Test
    public void testGetColourComponents() {
        // Crea un ResultSet simulato
        ResultSet mockResultSet = mock(ResultSet.class);
        QuerySolution mockSolution = mock(QuerySolution.class);
        Resource mockResource = mock(Resource.class);
        Literal mockLiteral = mock(Literal.class);

        // Configura il comportamento del mock
        when(mockResultSet.hasNext()).thenReturn(true, false);
        when(mockResultSet.nextSolution()).thenReturn(mockSolution);
        when(mockSolution.getResource("colour")).thenReturn(mockResource);
        when(mockResource.getLocalName()).thenReturn("Red");
        when(mockSolution.getLiteral("name")).thenReturn(mockLiteral);
        when(mockLiteral.getString()).thenReturn("Red");

        // Configura l'esecuzione della query
        when(queryExecutorMock.executeQuery(anyString())).thenReturn(mockResultSet);

        // Esegui il metodo da testare
        List<Colour> colourList = queryService.getColourComponents(new Laptop("TestLaptop"));

        // Verifica i risultati
        assertNotNull(colourList);
        assertEquals(1, colourList.size());
        assertEquals("Red", colourList.get(0).getColourName());
    }

    @Test
    public void testGetCoolingSystemComponents() {
        // Crea un ResultSet simulato
        ResultSet mockResultSet = mock(ResultSet.class);
        QuerySolution mockSolution = mock(QuerySolution.class);
        Resource mockResource = mock(Resource.class);
        Literal mockLiteral = mock(Literal.class);

        // Configura il comportamento del mock
        when(mockResultSet.hasNext()).thenReturn(true, false);
        when(mockResultSet.nextSolution()).thenReturn(mockSolution);
        when(mockSolution.getResource("coolingSystem")).thenReturn(mockResource);
        when(mockResource.getLocalName()).thenReturn("CoolingSystem1");
        when(mockSolution.getLiteral("type")).thenReturn(mockLiteral);
        when(mockLiteral.getString()).thenReturn("Air");

        // Configura l'esecuzione della query
        when(queryExecutorMock.executeQuery(anyString())).thenReturn(mockResultSet);

        // Esegui il metodo da testare
        List<CoolingSystem> coolingSystemList = queryService.getCoolingSystemComponents(new Laptop("TestLaptop"));

        // Verifica i risultati
        assertNotNull(coolingSystemList);
        assertEquals(1, coolingSystemList.size());
        assertEquals("CoolingSystem1", coolingSystemList.get(0).getCoolingSystemName());
        assertEquals("Air", coolingSystemList.get(0).getCoolingSystemType());
    }

    @Test
    public void testGetCpuComponents() {
        // Crea un ResultSet simulato
        ResultSet mockResultSet = mock(ResultSet.class);
        QuerySolution mockSolution = mock(QuerySolution.class);
        Resource mockResource = mock(Resource.class);
        Literal mockLiteral = mock(Literal.class);

        // Configura il comportamento del mock
        when(mockResultSet.hasNext()).thenReturn(true, false);
        when(mockResultSet.nextSolution()).thenReturn(mockSolution);
        when(mockSolution.getResource("cpu")).thenReturn(mockResource);
        when(mockResource.getLocalName()).thenReturn("Cpu1");
        when(mockSolution.getLiteral("speed")).thenReturn(mockLiteral);
        when(mockLiteral.getString()).thenReturn("3.2GHz");

        // Configura l'esecuzione della query
        when(queryExecutorMock.executeQuery(anyString())).thenReturn(mockResultSet);

        // Esegui il metodo da testare
        List<Cpu> cpuList = queryService.getCPUComponents(new Laptop("TestLaptop"));

        // Verifica i risultati
        assertNotNull(cpuList);
        assertEquals(1, cpuList.size());
        assertEquals("Cpu1", cpuList.get(0).getCpuName());
        assertEquals("3.2GHz", cpuList.get(0).getCpuSpeed());
    }
}
