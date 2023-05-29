package com.splitscale.reems.security.wrappers.energyStats.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.core.energyStats.EnergyStats;
import com.splitscale.reems.core.energyStats.edit.EditEnergyStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class EditEnergyStats {
  private SecurityService securityService;
  private EditEnergyStatsInteractor interactor;

  public EditEnergyStats(SecurityService securityService, EditEnergyStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(EnergyStats energyStats, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editEnergyStats(energyStats);
  }
}
