package com.splitscale.reems.security.wrappers.mitigation.read;

import com.splitscale.reems.core.mitigation.Mitigation;
import com.splitscale.reems.core.mitigation.read.ReadMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadMitigation {

  private SecurityService securityService;
  private ReadMitigationInteractor interactor;

  public ReadMitigation(SecurityService securityService, ReadMitigationInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<Mitigation> getAllMitigations(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllMitigation();
  }

  public Mitigation getMitigationById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getMitigationById(id);
  }
}
