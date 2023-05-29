package com.splitscale.reems.tenantInfo;

import com.splitscale.reems.tenantinfo.delete.DeleteTenantInfoInteractor;
import com.splitscale.reems.security.wrappers.tenantInfo.delete.DeleteTenantInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteTenantInfoTest {

    @Mock
    private DeleteTenantInfoInteractor interactor;

    private DeleteTenantInfo wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteTenantInfo(interactor);
    }

    @Test
    public void testDeleteTenantInfo() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";

        // Act
        wrapper.delete(id);

        // Assert
        verify(interactor, times(1)).deleteTenantInfo(id);
    }
}
