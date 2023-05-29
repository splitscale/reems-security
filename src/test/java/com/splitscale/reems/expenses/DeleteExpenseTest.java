package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.delete.DeleteExpenseInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.expenses.delete.DeleteExpense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteExpenseTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private DeleteExpenseInteractor interactor;

  private DeleteExpense wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new DeleteExpense(securityService, interactor);
  }

  @Test
  public void testDeleteExpense() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    // Act
    wrapper.delete(id, jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).deleteExpense(id);
  }

  @Test
  public void testDeleteAllExpenses() throws IOException, GeneralSecurityException {
    // Arrange
    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    // Act
    wrapper.deleteAll(jwtToken, userId);

    // Assert
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).deleteAllExpense();
  }
}
