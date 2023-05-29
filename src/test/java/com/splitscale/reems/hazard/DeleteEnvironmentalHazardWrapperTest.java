package com.splitscale.reems.hazard;

import com.splitscale.reems.hazard.environment.delete.DeleteEnvironmentalHazardInteractor;
import com.splitscale.reems.security.wrappers.hazard.delete.DeleteEnvironmentalHazard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteEnvironmentalHazardWrapperTest {

    @Mock
    private DeleteEnvironmentalHazardInteractor interactor;

    private DeleteEnvironmentalHazard wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteEnvironmentalHazard(interactor);
    }

    @Test
    public void testDeleteEnvironmentalHazard() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";

        // Act
        wrapper.delete(id);

        // Assert
        verify(interactor, times(1)).deleteEnvironmentalHazard(id);
    }
}
