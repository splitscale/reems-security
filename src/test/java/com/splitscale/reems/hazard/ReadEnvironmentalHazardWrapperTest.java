package com.splitscale.reems.hazard;

import com.splitscale.reems.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.hazard.environment.read.ReadEnvironmentalHazardInteractor;
import com.splitscale.reems.security.wrappers.hazard.read.ReadEnvironmentalHazardWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadEnvironmentalHazardWrapperTest {

    @Mock
    private ReadEnvironmentalHazardInteractor interactor;

    private ReadEnvironmentalHazardWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadEnvironmentalHazardWrapper(interactor);
    }

    @Test
    public void testGetAllEnvironmentalHazard() throws IOException, GeneralSecurityException {
        // Arrange
        EnvironmentalHazard hazard1 = new EnvironmentalHazard();
        EnvironmentalHazard hazard2 = new EnvironmentalHazard();
        List<EnvironmentalHazard> expectedHazards = Arrays.asList(hazard1, hazard2);

        when(interactor.getAllEnvironmentalHazard()).thenReturn(expectedHazards);

        // Act
        List<EnvironmentalHazard> actualHazards = wrapper.getAllEnvironmentalHazard();

        // Assert
        assertEquals(expectedHazards, actualHazards);
        verify(interactor, times(1)).getAllEnvironmentalHazard();
    }

    @Test
    public void testGetEnvironmentalHazardById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";
        EnvironmentalHazard expectedHazard = new EnvironmentalHazard();

        when(interactor.getEnvironmentalHazardById(id)).thenReturn(expectedHazard);

        // Act
        EnvironmentalHazard actualHazard = wrapper.getEnvironmentalHazardById(id);

        // Assert
        assertEquals(expectedHazard, actualHazard);
        verify(interactor, times(1)).getEnvironmentalHazardById(id);
    }
}
