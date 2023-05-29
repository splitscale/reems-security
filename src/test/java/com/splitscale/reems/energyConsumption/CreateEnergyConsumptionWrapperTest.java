package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.energy.consumption.EnergyConsumptionRequest;
import com.splitscale.reems.energy.consumption.create.CreateEnergyConsumptionInteractor;
import com.splitscale.reems.security.wrappers.energyConsumption.create.CreateEnergyConsumptionWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateEnergyConsumptionWrapperTest {

    @Mock
    private CreateEnergyConsumptionInteractor interactor;

    private CreateEnergyConsumptionWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreateEnergyConsumptionWrapper(interactor);
    }

    @Test
    public void testCreateEnergyConsumption() throws IOException, GeneralSecurityException {
        // Arrange
        EnergyConsumptionRequest request = new EnergyConsumptionRequest(null, null, null, null, null, null, null, null, 0);
        String expectedResponse = "Success";

        when(interactor.createEnergyConsumption(request)).thenReturn(expectedResponse);

        // Act
        String actualResponse = wrapper.create(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(interactor, times(1)).createEnergyConsumption(request);
    }
}
