package com.splitscale.reems.security.wrappers.expenses.read;

import com.splitscale.reems.expenses.Expense;
import com.splitscale.reems.expenses.read.ReadExpenseInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class ReadExpenseWrapper {

  private ReadExpenseInteractor interactor;

  public ReadExpenseWrapper(ReadExpenseInteractor interactor) {
    this.interactor = interactor;
  }

  public Expense getExpenseById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getExpenseById(id);
  }
}
