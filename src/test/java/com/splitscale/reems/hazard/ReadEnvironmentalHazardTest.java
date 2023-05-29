package com.splitscale.reems.hazard;

import com.splitscale.reems.core.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.core.hazard.environment.read.ReadEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.hazard.read.ReadEnvironmentalHazard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadEnvironmentalHazardTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private ReadEnvironmentalHazardInteractor interactor;

  private ReadEnvironmentalHazard wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new ReadEnvironmentalHazard(securityService, interactor);
  }

  @Test
  public void testGetAllEnvironmentalHazard() throws IOException, GeneralSecurityException {
    // Arrange
    EnvironmentalHazard hazard1 = new EnvironmentalHazard();
    EnvironmentalHazard hazard2 = new EnvironmentalHazard();
    List<EnvironmentalHazard> expectedHazards = Arrays.asList(hazard1, hazard2);

    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    doNothing().when(securityService).validateJwt(jwtToken, userId);
    when(interactor.getAllEnvironmentalHazard()).thenReturn(expectedHazards);

    // Act
    List<EnvironmentalHazard> actualHazards = wrapper.getAllEnvironmentalHazard(jwtToken, userId);

    // Assert
    assertEquals(expectedHazards, actualHazards);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).getAllEnvironmentalHazard();
  }

  @Test
  public void testGetEnvironmentalHazardById() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    EnvironmentalHazard expectedHazard = new EnvironmentalHazard();

    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    doNothing().when(securityService).validateJwt(jwtToken, userId);
    when(interactor.getEnvironmentalHazardById(id)).thenReturn(expectedHazard);

    // Act
    EnvironmentalHazard actualHazard = wrapper.getEnvironmentalHazardById(id, jwtToken, userId);

    // Assert
    assertEquals(expectedHazard, actualHazard);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).getEnvironmentalHazardById(id);
  }

}
