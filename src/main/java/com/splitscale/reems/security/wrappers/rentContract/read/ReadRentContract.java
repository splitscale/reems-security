package com.splitscale.reems.security.wrappers.rentContract.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.rentContract.RentContract;
import com.splitscale.reems.rentContract.read.ReadRentContractInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class ReadRentContract {
  private SecurityService securityService;
  private ReadRentContractInteractor interactor;

  public ReadRentContract(SecurityService securityService, ReadRentContractInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<RentContract> getAllRentContract(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllRentContract();
  }

  public RentContract getPropertyId(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getById(id);
  }
}
