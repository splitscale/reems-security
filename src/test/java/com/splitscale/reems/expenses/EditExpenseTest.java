package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.edit.EditExpenseInteractor;
import com.splitscale.reems.expenses.Expense;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.expenses.edit.EditExpense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditExpenseTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private EditExpenseInteractor interactor;

  private EditExpense wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new EditExpense(securityService, interactor);
  }

  @Test
  public void testEditExpense() throws IOException, GeneralSecurityException {
    // Arrange
    Expense expense = new Expense(null, null, null, null, null);
    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    // Act
    wrapper.edit(expense, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).editExpense(expense);
  }
}
