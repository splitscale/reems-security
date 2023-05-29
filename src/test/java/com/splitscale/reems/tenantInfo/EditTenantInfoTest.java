package com.splitscale.reems.tenantInfo;

import com.splitscale.reems.tenantinfo.TenantInfo;
import com.splitscale.reems.tenantinfo.edit.EditTenantInfoInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.tenantInfo.edit.EditTenantInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditTenantInfoTest {

    @Mock
    private SecurityService service;

    @Mock
    private EditTenantInfoInteractor interactor;

    private EditTenantInfo wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditTenantInfo(service, interactor);
    }

    @Test
    public void testEditTenantInfo() throws IOException, GeneralSecurityException {
        // Arrange
        TenantInfo tenantInfo = new TenantInfo(null, null, null, null);
        String jwtToken = "token";
        String userId = "userId";

        // Act
        wrapper.edit(tenantInfo, jwtToken, userId);

        // Assert
        verify(interactor, times(1)).editTenantInfo(tenantInfo);
    }
}
