package com.splitscale.reems.security.wrappers.rentContract.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.rentContract.RentContract;
import com.splitscale.reems.rentContract.edit.EditRentContractInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class EditRentContract {
  private SecurityService securityService;
  private EditRentContractInteractor interactor;

  public EditRentContract(SecurityService securityService, EditRentContractInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(RentContract rentContract, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editRentContract(rentContract);
  }
}
