package com.splitscale.reems.security.wrappers.expenseStats.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.core.expenseStats.ExpenseStats;
import com.splitscale.reems.core.expenseStats.read.ReadExpenseStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class ReadExpenseStats {

  private SecurityService securityService;
  private ReadExpenseStatsInteractor interactor;

  public ReadExpenseStats(SecurityService securityService, ReadExpenseStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<ExpenseStats> getAllExpenseStats(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllExpenseStats();
  }

  public ExpenseStats getExpenseStatsById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllExpenseStatsbyId(id);
  }
}
