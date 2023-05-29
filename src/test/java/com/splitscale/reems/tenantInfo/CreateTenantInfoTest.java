package com.splitscale.reems.tenantinfo;

import com.splitscale.reems.core.tenantinfo.TenantInfoRequest;
import com.splitscale.reems.core.tenantinfo.create.CreateTenantInfoInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.tenantInfo.create.CreateTenantInfo;

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

  @Mock
  private SecurityService service;

  private CreateTenantInfo wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new CreateTenantInfo(service, interactor);
  }

  @Test
  public void testCreateTenantInfo() throws IOException, GeneralSecurityException {
    // Arrange
    TenantInfoRequest request = new TenantInfoRequest(null, null, null, null);
    String jwtToken = "token";
    String userId = "userId";

    String expectedResponse = "Success";

    when(interactor.createTenantInfo(request)).thenReturn(expectedResponse);

    // Act
    String actualResponse = wrapper.create(request, jwtToken, userId);

    // Assert
    assertEquals(expectedResponse, actualResponse);
    verify(interactor, times(1)).createTenantInfo(request);
  }
}