package com.splitscale.reems.properties;

import com.splitscale.reems.properties.delete.DeletePropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.properties.delete.DeleteProperty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeletePropertyTest {

    @Mock
    private SecurityService securityService;

    @Mock
    private DeletePropertyInteractor interactor;

    private DeleteProperty wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteProperty(securityService, interactor);
    }

    @Test
    public void testDeleteProperty() throws IOException, GeneralSecurityException {
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
        verify(interactor, times(1)).deleteProperty(id);
    }
}
