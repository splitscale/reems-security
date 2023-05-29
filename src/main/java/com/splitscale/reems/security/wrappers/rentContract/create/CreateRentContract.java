package com.splitscale.reems.security.wrappers.rentContract.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.core.rentContract.RentContractRequest;
import com.splitscale.reems.core.rentContract.create.CreateRentContractInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class CreateRentContract {
  private SecurityService securityService;
  private CreateRentContractInteractor interactor;

  public CreateRentContract(SecurityService securityService, CreateRentContractInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(RentContractRequest rentContractRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createRentContract(rentContractRequest);
  }
}
