package com.splitscale.reems.wrappers.expenses.delete;

import com.splitscale.reems.expenses.delete.DeleteExpenseInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteExpenseWrapper {

  private DeleteExpenseInteractor interactor;

  public DeleteExpenseWrapper(DeleteExpenseInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteExpense(id);
  }

  public void deleteAll() throws IOException, GeneralSecurityException {
    interactor.deleteAllExpense();
  }
}
