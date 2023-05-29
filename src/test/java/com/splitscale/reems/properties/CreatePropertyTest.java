package com.splitscale.reems.properties;

import com.splitscale.reems.properties.create.CreatePropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.properties.create.CreateProperty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreatePropertyTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private CreatePropertyInteractor interactor;

  private CreateProperty createProperty;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    createProperty = new CreateProperty(securityService, interactor);
  }

  @Test
  void testCreateProperty() throws IOException, GeneralSecurityException {
    // Arrange
    PropertyRequest propertyRequest = new PropertyRequest();
    String jwtToken = "exampleJwtToken";
    String userId = "exampleUserId";
    String expectedResult = "exampleResult";

    // Mock the security service to allow the method call
    doNothing().when(securityService).validateJwt(jwtToken, userId);

    // Mock the interactor to return the expected result
    when(interactor.createProperty(propertyRequest)).thenReturn(expectedResult);

    // Act
    String actualResult = createProperty.create(propertyRequest, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).createProperty(propertyRequest);
    assertEquals(expectedResult, actualResult);
  }
}
