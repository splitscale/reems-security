package com.splitscale.reems.tenantInfo;

import com.splitscale.reems.tenantinfo.TenantInfoRequest;
import com.splitscale.reems.tenantinfo.create.CreateTenantInfoInteractor;
import com.splitscale.reems.wrappers.tenantInfo.create.CreateTenantInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateTenantInfoTest {

    @Mock
    private CreateTenantInfoInteractor interactor;

    private CreateTenantInfo wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreateTenantInfo(interactor);
    }

    @Test
    public void testCreateTenantInfo() throws IOException, GeneralSecurityException {
        // Arrange
        TenantInfoRequest request = new TenantInfoRequest(null, null, null, null);
        String expectedResponse = "Success";

        when(interactor.createTenantInfo(request)).thenReturn(expectedResponse);

        // Act
        String actualResponse = wrapper.create(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(interactor, times(1)).createTenantInfo(request);
    }
}
