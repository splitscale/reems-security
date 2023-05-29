package com.splitscale.reems.energyConsumption;

import com.splitscale.reems.core.energy.consumption.EnergyConsumptionRequest;
import com.splitscale.reems.core.energy.consumption.create.CreateEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.energyConsumption.create.CreateEnergyConsumption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateEnergyConsumptionTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private CreateEnergyConsumptionInteractor interactor;

  private CreateEnergyConsumption wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new CreateEnergyConsumption(securityService, interactor);
  }

  @Test
  public void testCreateEnergyConsumption() throws IOException, GeneralSecurityException {
    // Arrange
    EnergyConsumptionRequest request = new EnergyConsumptionRequest(null, null, null, null, null, null, null, null, 0);
    String expectedResponse = "Success";
    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    doNothing().when(securityService).validateJwt(jwtToken, userId);
    when(interactor.createEnergyConsumption(request)).thenReturn(expectedResponse);

    // Act
    String actualResponse = wrapper.create(request, jwtToken, userId);

    // Assert
    assertEquals(expectedResponse, actualResponse);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).createEnergyConsumption(request);
  }
}
