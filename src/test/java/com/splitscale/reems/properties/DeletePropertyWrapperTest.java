package com.splitscale.reems.properties;

import com.splitscale.reems.properties.delete.DeletePropertyInteractor;
import com.splitscale.reems.security.wrappers.properties.delete.DeleteProperty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeletePropertyWrapperTest {

    @Mock
    private DeletePropertyInteractor interactor;

    private DeleteProperty wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteProperty(interactor);
    }

    @Test
    public void testDeleteProperty() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";

        // Act
        wrapper.delete(id);

        // Assert
        verify(interactor, times(1)).deleteProperty(id);
    }
}
