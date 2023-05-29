package com.splitscale.reems.wrappers.expenseStats.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.expenseStats.delete.DeleteExpenseStatsInteractor;

public class DeleteExpenseStatsWrapper {
  private DeleteExpenseStatsInteractor interactor;

  public DeleteExpenseStatsWrapper(DeleteExpenseStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteExpenseStats(id);
  }
}
