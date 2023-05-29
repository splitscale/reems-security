package com.splitscale.reems.mitigation;

import com.splitscale.reems.mitigation.read.ReadMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.mitigation.read.ReadMitigation;

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

public class ReadMitigationTest {

    @Mock
    private ReadMitigationInteractor interactor;

    @Mock
    private SecurityService securityService;

    private ReadMitigation wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadMitigation(securityService, interactor);
    }

    @Test
    public void testGetAllMitigations() throws IOException, GeneralSecurityException {
        // Arrange
        List<Mitigation> expectedMitigations = new ArrayList<>();

        when(interactor.getAllMitigation()).thenReturn(expectedMitigations);

        // Act
        List<Mitigation> actualMitigations = wrapper.getAllMitigations("jwtToken", "userId");

        // Assert
        assertEquals(expectedMitigations, actualMitigations);
        verify(securityService, times(1)).validateJwt("jwtToken", "userId");
        verify(interactor, times(1)).getAllMitigation();
    }

    @Test
    public void testGetMitigationById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";
        Mitigation expectedMitigation = new Mitigation();

        when(interactor.getMitigationById(id)).thenReturn(expectedMitigation);

        // Act
        Mitigation actualMitigation = wrapper.getMitigationById(id, "jwtToken", "userId");

        // Assert
        assertEquals(expectedMitigation, actualMitigation);
        verify(securityService, times(1)).validateJwt("jwtToken", "userId");
        verify(interactor, times(1)).getMitigationById(id);
    }
}
