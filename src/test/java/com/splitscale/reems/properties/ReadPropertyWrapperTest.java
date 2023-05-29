package com.splitscale.reems.properties;

import com.splitscale.reems.properties.read.ReadPropertyInteractor;
import com.splitscale.reems.wrappers.properties.read.ReadPropertyWrapper;

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

public class ReadPropertyWrapperTest {

    @Mock
    private ReadPropertyInteractor interactor;

    private ReadPropertyWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadPropertyWrapper(interactor);
    }

    @Test
    public void testGetProperty() throws IOException, GeneralSecurityException {
        // Arrange
        List<Property> expectedProperties = new ArrayList<>();

        when(interactor.getAllProperty()).thenReturn(expectedProperties);

        // Act
        List<Property> actualProperties = wrapper.getProperty();

        // Assert
        assertEquals(expectedProperties, actualProperties);
        verify(interactor, times(1)).getAllProperty();
    }

    @Test
    public void testGetPropertyById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";
        Property expectedProperty = new Property(id, null, null, id, id, id);

        when(interactor.getById(id)).thenReturn(expectedProperty);

        // Act
        Property actualProperty = wrapper.getPropertyId(id);

        // Assert
        assertEquals(expectedProperty, actualProperty);
        verify(interactor, times(1)).getById(id);
    }
}
