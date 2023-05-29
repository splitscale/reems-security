package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.edit.EditMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.mitigation.edit.EditMitigation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditMitigationTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private EditMitigationInteractor interactor;

  private EditMitigation wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new EditMitigation(securityService, interactor);
  }

  @Test
  public void testEditMitigation() throws IOException, GeneralSecurityException {
    // Arrange
    Mitigation mitigation = new Mitigation(null, null, null, null, null, null, null, null);
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.edit(mitigation, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).editMitigation(mitigation);
  }
}
