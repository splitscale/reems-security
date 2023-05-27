package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.read.ReadMitigationInteractor;
import com.splitscale.reems.wrappers.mitigation.read.ReadMitigationWrapper;

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

public class ReadMitigationWrapperTest {

    @Mock
    private ReadMitigationInteractor interactor;

    private ReadMitigationWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadMitigationWrapper(interactor);
    }

    @Test
    public void testGetAllMitigations() throws IOException, GeneralSecurityException {
        // Arrange
        List<Mitigation> expectedMitigations = new ArrayList<>();

        when(interactor.getAllMitigation()).thenReturn(expectedMitigations);

        // Act
        List<Mitigation> actualMitigations = wrapper.getAllMitigations();

        // Assert
        assertEquals(expectedMitigations, actualMitigations);
        verify(interactor, times(1)).getAllMitigation();
    }

    @Test
    public void testGetMitigationById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";
        Mitigation expectedMitigation = new Mitigation(id, id, id, id, id, null, null);

        when(interactor.getMitigationById(id)).thenReturn(expectedMitigation);

        // Act
        Mitigation actualMitigation = wrapper.getMitigationById(id);

        // Assert
        assertEquals(expectedMitigation, actualMitigation);
        verify(interactor, times(1)).getMitigationById(id);
    }
}
