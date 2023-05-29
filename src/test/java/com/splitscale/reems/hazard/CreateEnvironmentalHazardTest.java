package com.splitscale.reems.hazard;

import com.splitscale.reems.hazard.environment.EnvironmentalHazardRequest;
import com.splitscale.reems.hazard.environment.create.CreateEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.hazard.create.CreateEnvironmentalHazard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateEnvironmentalHazardTest {

  @Mock
  private CreateEnvironmentalHazardInteractor interactor;

  @Mock
  private SecurityService securityService;

  private CreateEnvironmentalHazard wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new CreateEnvironmentalHazard(securityService, interactor);
  }

  @Test
  public void testCreateEnvironmentalHazard() throws IOException, GeneralSecurityException {
    // Arrange
    EnvironmentalHazardRequest request = new EnvironmentalHazardRequest(null, null, null, null, null, null, null, null);
    String jwtToken = "jwtToken";
    String userId = "userId";
    String expectedResponse = "Success";

    when(interactor.createEnvironmentalHazard(request)).thenReturn(expectedResponse);
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    String actualResponse = wrapper.create(request, jwtToken, userId);

    // Assert
    assertEquals(expectedResponse, actualResponse);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).createEnvironmentalHazard(request);
  }
}
