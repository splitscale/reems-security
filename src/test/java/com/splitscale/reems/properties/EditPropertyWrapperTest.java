package com.splitscale.reems.properties;

import com.splitscale.reems.properties.edit.EditPropertyInteractor;
import com.splitscale.reems.security.wrappers.properties.edit.EditPropertyWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditPropertyWrapperTest {

    @Mock
    private EditPropertyInteractor interactor;

    private EditPropertyWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditPropertyWrapper(interactor);
    }

    @Test
    public void testEditProperty() throws IOException, GeneralSecurityException {
        // Arrange
        Property property = new Property(null, null, null, null, null, null);

        // Act
        wrapper.edit(property);

        // Assert
        verify(interactor, times(1)).editProperty(property);
    }
}
