package com.splitscale.reems.hazard;

import com.splitscale.reems.core.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.core.hazard.environment.edit.EditEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.hazard.edit.EditEnvironmentalHazard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditEnvironmentalHazardTest {

  @Mock
  private EditEnvironmentalHazardInteractor interactor;

  @Mock
  private SecurityService securityService;

  private EditEnvironmentalHazard wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new EditEnvironmentalHazard(securityService, interactor);
  }

  @Test
  public void testEditEnvironmentalHazard() throws IOException, GeneralSecurityException {
    // Arrange
    EnvironmentalHazard environmentalHazard = new EnvironmentalHazard();
    String jwtToken = "jwtToken";
    String userId = "userId";

    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.edit(environmentalHazard, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).editEnvironmentalHazard(environmentalHazard);
  }
}
