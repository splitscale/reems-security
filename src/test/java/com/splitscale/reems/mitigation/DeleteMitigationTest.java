package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.delete.DeleteMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.mitigation.delete.DeleteMitigation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteMitigationTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private DeleteMitigationInteractor interactor;

  private DeleteMitigation wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new DeleteMitigation(securityService, interactor);
  }

  @Test
  public void testDeleteMitigation() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.delete(id, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).deleteMitigation(id);
  }
}
