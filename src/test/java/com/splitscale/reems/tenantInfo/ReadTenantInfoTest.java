package com.splitscale.reems.tenantinfo;

import com.splitscale.reems.core.tenantinfo.TenantInfo;
import com.splitscale.reems.core.tenantinfo.read.ReadTenantInfoInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.tenantInfo.read.ReadTenantInfo;

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

public class ReadTenantInfoTest {

  @Mock
  private SecurityService service;

  @Mock
  private ReadTenantInfoInteractor interactor;

  private ReadTenantInfo readTenantInfo;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    readTenantInfo = new ReadTenantInfo(service, interactor);
  }

  @Test
  public void testGetAllTenantInfo() throws IOException, GeneralSecurityException {
    // Arrange
    List<TenantInfo> expectedTenantInfoList = new ArrayList<>();
    expectedTenantInfoList.add(new TenantInfo("1", "Tenant 1", null, null));
    expectedTenantInfoList.add(new TenantInfo("2", "Tenant 2", null, null));

    when(interactor.getAllTenantInfo()).thenReturn(expectedTenantInfoList);

    // Act
    String jwtToken = "token";
    String userId = "userId";

    List<TenantInfo> actualTenantInfoList = readTenantInfo.getAllTenantInfo(jwtToken, userId);

    // Assert
    assertEquals(expectedTenantInfoList, actualTenantInfoList);
    verify(interactor, times(1)).getAllTenantInfo();
  }

  @Test
  public void testGetTenantInfoById() throws IOException, GeneralSecurityException {
    // Arrange
    String tenantId = "1";
    TenantInfo expectedTenantInfo = new TenantInfo();

    when(interactor.getTenantInfoById(tenantId)).thenReturn(expectedTenantInfo);

    // Act
    String jwtToken = "token";
    String userId = "userId";

    TenantInfo actualTenantInfo = readTenantInfo.getTenantInfoById(tenantId, jwtToken, userId);

    // Assert
    assertEquals(expectedTenantInfo, actualTenantInfo);
    verify(interactor, times(1)).getTenantInfoById(tenantId);
  }
}
