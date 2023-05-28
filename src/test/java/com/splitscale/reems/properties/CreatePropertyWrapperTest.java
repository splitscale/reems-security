package com.splitscale.reems.properties;

import com.splitscale.reems.properties.create.CreatePropertyInteractor;
import com.splitscale.reems.wrappers.properties.create.CreatePropertyWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreatePropertyWrapperTest {

    @Mock
    private CreatePropertyInteractor interactor;

    private CreatePropertyWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreatePropertyWrapper(interactor);
    }

    @Test
    public void testCreateProperty() throws IOException, GeneralSecurityException {
        // Arrange
        PropertyRequest request = new PropertyRequest(null, null, null);
        String expectedResponse = "Success";

        when(interactor.createProperty(request)).thenReturn(expectedResponse);

        // Act
        String actualResponse = wrapper.create(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(interactor, times(1)).createProperty(request);
    }
}
