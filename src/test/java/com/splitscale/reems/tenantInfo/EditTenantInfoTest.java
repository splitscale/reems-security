package com.splitscale.reems.tenantInfo;

import com.splitscale.reems.tenantinfo.TenantInfo;
import com.splitscale.reems.tenantinfo.edit.EditTenantInfoInteractor;
import com.splitscale.reems.wrappers.tenantInfo.edit.EditTenantInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditTenantInfoTest {

    @Mock
    private EditTenantInfoInteractor interactor;

    private EditTenantInfo wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditTenantInfo(interactor);
    }

    @Test
    public void testEditTenantInfo() throws IOException, GeneralSecurityException {
        // Arrange
        TenantInfo tenantInfo = new TenantInfo(null, null, null, null);

        // Act
        wrapper.edit(tenantInfo);

        // Assert
        verify(interactor, times(1)).editTenantInfo(tenantInfo);
    }
}
