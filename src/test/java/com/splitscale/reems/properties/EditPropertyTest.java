package com.splitscale.reems.properties;

import com.splitscale.reems.properties.edit.EditPropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.properties.edit.EditProperty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditPropertyTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private EditPropertyInteractor interactor;

  private EditProperty wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new EditProperty(securityService, interactor);
  }

  @Test
  public void testEditProperty() throws IOException, GeneralSecurityException {
    // Arrange
    Property property = new Property(null, null, null, null, null, null);
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Act
    wrapper.edit(property, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).editProperty(property);
  }
}
