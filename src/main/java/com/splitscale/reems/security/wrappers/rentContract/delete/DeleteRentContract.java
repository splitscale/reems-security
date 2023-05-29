package com.splitscale.reems.security.wrappers.rentContract.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.core.rentContract.delete.DeleteRentContractInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class DeleteRentContract {
  private SecurityService securityService;
  private DeleteRentContractInteractor interactor;

  public DeleteRentContract(SecurityService securityService, DeleteRentContractInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteRentContract(id);
  }
}
