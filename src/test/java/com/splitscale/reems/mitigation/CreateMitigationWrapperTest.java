package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.create.CreateMitigationInteractor;
import com.splitscale.reems.security.wrappers.mitigation.create.CreateMitigationWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateMitigationWrapperTest {

    @Mock
    private CreateMitigationInteractor interactor;

    private CreateMitigationWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreateMitigationWrapper(interactor);
    }

    @Test
    public void testCreateMitigation() throws IOException, GeneralSecurityException {
        // Arrange
        MitigationRequest request = new MitigationRequest("Sample mitigation", null, null, null, null, null, null, null);

        String expectedResponse = "Success";

        when(interactor.createMitigation(request)).thenReturn(expectedResponse);

        // Act
        String actualResponse = wrapper.create(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(interactor, times(1)).createMitigation(request);
    }
}
