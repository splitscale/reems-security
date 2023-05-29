package com.splitscale.reems.properties;

import com.splitscale.reems.properties.read.ReadPropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.properties.read.ReadProperty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadPropertyTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private ReadPropertyInteractor interactor;

  private ReadProperty wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new ReadProperty(securityService, interactor);
  }

  @Test
  public void testGetProperty() throws IOException, GeneralSecurityException {
    // Arrange
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";
    List<Property> expectedProperties = new ArrayList<>();

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Mock the interactor to return the expected properties
    when(interactor.getAllProperty()).thenReturn(expectedProperties);

    // Act
    List<Property> actualProperties = wrapper.getProperty(jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).getAllProperty();
    assertEquals(expectedProperties, actualProperties);
  }

  @Test
  public void testGetPropertyId() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";
    Property expectedProperty = new Property(null, null, null, null, null, null);

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Mock the interactor to return the expected property
    when(interactor.getById(id)).thenReturn(expectedProperty);

    // Act
    Property actualProperty = wrapper.getPropertyId(id, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).getById(id);
    assertEquals(expectedProperty, actualProperty);
  }
}
