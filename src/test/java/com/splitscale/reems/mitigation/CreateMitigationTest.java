package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.create.CreateMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.mitigation.create.CreateMitigation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateMitigationTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private CreateMitigationInteractor interactor;

  private CreateMitigation wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new CreateMitigation(securityService, interactor);
  }

  @Test
  public void testCreateMitigation() throws IOException, GeneralSecurityException {
    // Arrange
    MitigationRequest request = new MitigationRequest("Sample mitigation", null, null, null, null, null, null, null);
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";
    String expectedResponse = "Success";

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Mock the interactor to return the expected response
    when(interactor.createMitigation(request)).thenReturn(expectedResponse);

    // Act
    String actualResponse = wrapper.create(request, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).createMitigation(request);
    assertEquals(expectedResponse, actualResponse);
  }
}
