package com.splitscale.reems.wrappers.expenseStats.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.expenseStats.ExpenseStats;
import com.splitscale.reems.expenseStats.read.ReadExpenseStatsInteractor;

public class ReadExpenseStatsWrapper {
  private ReadExpenseStatsInteractor interactor;

  public ReadExpenseStatsWrapper(ReadExpenseStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public List<ExpenseStats> getAllExpenseStats()
      throws IOException, GeneralSecurityException {
    return interactor.getAllExpenseStats();
  }

  public ExpenseStats getExpenseStatsnById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getAllExpenseStatsbyId(id);
  }
}
