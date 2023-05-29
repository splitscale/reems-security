package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.core.energy.consumption.EnergyConsumption;
import com.splitscale.reems.core.energy.consumption.edit.EditEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.energyConsumption.edit.EditEnergyConsumption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;

public class EditEnergyConsumptionTest {

  @Mock
  private EditEnergyConsumptionInteractor interactor;

  @Mock
  private SecurityService securityService;

  private EditEnergyConsumption wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new EditEnergyConsumption(securityService, interactor);
  }

  @Test
  public void testEditEnergyConsumption() throws IOException, GeneralSecurityException {
    // Arrange
    EnergyConsumption energyConsumption = new EnergyConsumption(null, null, null, null, null, null, null, null);
    String jwtToken = "yourJwtToken";
    String userId = "yourUserId";

    // Mock the securityService.validateJwt() method
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.edit(energyConsumption, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).editEnergyConsumption(energyConsumption);
  }
}
