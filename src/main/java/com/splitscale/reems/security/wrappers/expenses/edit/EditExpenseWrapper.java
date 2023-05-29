package com.splitscale.reems.security.wrappers.expenses.edit;

import com.splitscale.reems.expenses.Expense;
import com.splitscale.reems.expenses.edit.EditExpenseInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditExpenseWrapper {

  private EditExpenseInteractor interactor;

  public EditExpenseWrapper(EditExpenseInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(Expense expense)
      throws IOException, GeneralSecurityException {
    interactor.editExpense(expense);
  }
}
