package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.energy.consumption.EnergyConsumption;
import com.splitscale.reems.energy.consumption.read.ReadEnergyConsumptionInteractor;
import com.splitscale.reems.wrappers.energyConsumption.read.ReadEnergyConsumptionWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadEnergyConsumptionWrapperTest {

    @Mock
    private ReadEnergyConsumptionInteractor interactor;

    private ReadEnergyConsumptionWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadEnergyConsumptionWrapper(interactor);
    }

    @Test
    public void testGetAllEnergyConsumption() throws IOException, GeneralSecurityException {
        // Arrange
        List<EnergyConsumption> expectedConsumptionList = new ArrayList<>();
        expectedConsumptionList.add(new EnergyConsumption(null, null, null, null, null, null, null, null));
        expectedConsumptionList.add(new EnergyConsumption(null, null, null, null, null, null, null, null));

        when(interactor.getAllEnergyConsumption()).thenReturn(expectedConsumptionList);

        // Act
        List<EnergyConsumption> actualConsumptionList = wrapper.getAllEnergyConsumption();

        // Assert
        assertEquals(expectedConsumptionList, actualConsumptionList);
        verify(interactor, times(1)).getAllEnergyConsumption();
    }

    @Test
    public void testGetEnergyConsumptionById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";
        EnergyConsumption expectedConsumption = new EnergyConsumption(id, id, id, id, id, id, null, null);

        when(interactor.getEnergyConsumptionById(id)).thenReturn(expectedConsumption);

        // Act
        EnergyConsumption actualConsumption = wrapper.getEnergyConsumptionById(id);

        // Assert
        assertEquals(expectedConsumption, actualConsumption);
        verify(interactor, times(1)).getEnergyConsumptionById(id);
    }
}
