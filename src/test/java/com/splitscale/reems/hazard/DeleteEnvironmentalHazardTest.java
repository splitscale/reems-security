package com.splitscale.reems.hazard;

import com.splitscale.reems.core.hazard.environment.delete.DeleteEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.hazard.delete.DeleteEnvironmentalHazard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteEnvironmentalHazardTest {

  @Mock
  private DeleteEnvironmentalHazardInteractor interactor;

  @Mock
  private SecurityService securityService;

  private DeleteEnvironmentalHazard wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new DeleteEnvironmentalHazard(securityService, interactor);
  }

  @Test
  public void testDeleteEnvironmentalHazard() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    String jwtToken = "jwtToken";
    String userId = "userId";

    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.delete(id, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).deleteEnvironmentalHazard(id);
  }
}
