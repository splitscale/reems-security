package com.splitscale.reems.hazard;

import com.splitscale.reems.hazard.environment.EnvironmentalHazardRequest;
import com.splitscale.reems.hazard.environment.create.CreateEnvironmentalHazardInteractor;
import com.splitscale.reems.wrappers.hazard.create.CreateEnvironmentalHazardWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateEnvironmentalHazardWrapperTest {

    @Mock
    private CreateEnvironmentalHazardInteractor interactor;

    private CreateEnvironmentalHazardWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreateEnvironmentalHazardWrapper(interactor);
    }

    @Test
    public void testCreateEnvironmentalHazard() throws IOException, GeneralSecurityException {
        // Arrange
        EnvironmentalHazardRequest request = new EnvironmentalHazardRequest(null, null, null, null, null, null, null, null);
        String expectedResponse = "Success";

        when(interactor.createEnvironmentalHazard(request)).thenReturn(expectedResponse);

        // Act
        String actualResponse = wrapper.create(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(interactor, times(1)).createEnvironmentalHazard(request);
    }
}
