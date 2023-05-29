package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.energy.consumption.delete.DeleteEnergyConsumptionInteractor;
import com.splitscale.reems.security.wrappers.energyConsumption.delete.DeleteEnergyConsumptionWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DeleteEnergyConsumptionWrapperTest {

    @Mock
    private DeleteEnergyConsumptionInteractor interactor;

    private DeleteEnergyConsumptionWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteEnergyConsumptionWrapper(interactor);
    }

    @Test
    public void testDeleteEnergyConsumption() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";

        // Act
        wrapper.delete(id);

        // Assert
        verify(interactor, times(1)).DeleteEnergyConsumption(id);
    }
}
