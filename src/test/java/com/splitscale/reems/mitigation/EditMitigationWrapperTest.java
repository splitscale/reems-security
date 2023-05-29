package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.edit.EditMitigationInteractor;
import com.splitscale.reems.security.wrappers.mitigation.edit.EditMitigationWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditMitigationWrapperTest {

    @Mock
    private EditMitigationInteractor interactor;

    private EditMitigationWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditMitigationWrapper(interactor);
    }

    @Test
    public void testEditMitigation() throws IOException, GeneralSecurityException {
        // Arrange
        Mitigation mitigation = new Mitigation(null, null, null, null, null, null, null, null);

        // Act
        wrapper.edit(mitigation);

        // Assert
        verify(interactor, times(1)).editMitigation(mitigation);
    }
}
