package com.splitscale.reems.hazard;

import com.splitscale.reems.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.hazard.environment.edit.EditEnvironmentalHazardInteractor;
import com.splitscale.reems.wrappers.hazard.edit.EditEnvironmentalHazardWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditEnvironmentalHazardWrapperTest {

    @Mock
    private EditEnvironmentalHazardInteractor interactor;

    private EditEnvironmentalHazardWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditEnvironmentalHazardWrapper(interactor);
    }

    @Test
    public void testEditEnvironmentalHazard() throws IOException, GeneralSecurityException {
        // Arrange
        EnvironmentalHazard environmentalHazard = new EnvironmentalHazard();

        // Act
        wrapper.edit(environmentalHazard);

        // Assert
        verify(interactor, times(1)).editEnvironmentalHazard(environmentalHazard);
    }
}
