package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.core.energy.consumption.delete.DeleteEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.energyConsumption.delete.DeleteEnergyConsumption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;

public class DeleteEnergyConsumptionTest {

  @Mock
  private DeleteEnergyConsumptionInteractor interactor;

  @Mock
  private SecurityService securityService;

  private DeleteEnergyConsumption wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new DeleteEnergyConsumption(securityService, interactor);
  }

  @Test
  public void testDeleteEnergyConsumption() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    String jwtToken = "yourJwtToken";
    String userId = "yourUserId";

    // Mock the securityService.validateJwt() method
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.delete(id, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).DeleteEnergyConsumption(id);
  }
}
