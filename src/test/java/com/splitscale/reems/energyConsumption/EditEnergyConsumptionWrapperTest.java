package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.energy.consumption.EnergyConsumption;
import com.splitscale.reems.energy.consumption.edit.EditEnergyConsumptionInteractor;
import com.splitscale.reems.security.wrappers.energyConsumption.edit.EditEnergyConsumption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditEnergyConsumptionWrapperTest {

    @Mock
    private EditEnergyConsumptionInteractor interactor;

    private EditEnergyConsumption wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditEnergyConsumption(interactor);
    }

    @Test
    public void testEditEnergyConsumption() throws IOException, GeneralSecurityException {
        // Arrange
        EnergyConsumption energyConsumption = new EnergyConsumption(null, null, null, null, null, null, null, null);

        // Act
        wrapper.edit(energyConsumption);

        // Assert
        verify(interactor, times(1)).editEnergyConsumption(energyConsumption);
    }
}
