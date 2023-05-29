package com.splitscale.reems.expenses;

import com.splitscale.reems.core.expenses.read.ReadExpenseInteractor;
import com.splitscale.reems.core.expenses.Expense;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.expenses.read.ReadExpense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadExpenseTest {

  @Mock
  private SecurityService securityService;

  @Mock
  private ReadExpenseInteractor interactor;

  private ReadExpense wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new ReadExpense(securityService, interactor);
  }

  @Test
  public void testGetExpenseById() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";
    Expense expectedExpense = new Expense();
    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    doNothing().when(securityService).validateJwt(jwtToken, userId);
    when(interactor.getExpenseById(id)).thenReturn(expectedExpense);

    // Act
    Expense actualExpense = wrapper.getExpenseById(id, jwtToken, userId);

    // Assert
    assertEquals(expectedExpense, actualExpense);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).getExpenseById(id);
  }
}
