package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.create.CreateExpenseInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.expenses.create.CreateExpense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateExpenseTest {

    @Mock
    private SecurityService securityService;

    @Mock
    private CreateExpenseInteractor interactor;

    private CreateExpense wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreateExpense(securityService, interactor);
    }

    @Test
public void testCreateExpense() throws IOException, GeneralSecurityException {
    // Arrange
    ExpenseRequest request = new ExpenseRequest(null, null, null, null, null);
    String expectedResponse = "Success";

    String jwtToken = "your-jwt-token";
    String userId = "your-user-id";

    doNothing().when(securityService).validateJwt(jwtToken, userId);
    when(interactor.createExpense(request)).thenReturn(expectedResponse);

    // Act
    String actualResponse = wrapper.create(request, jwtToken, userId);

    // Assert
    assertEquals(expectedResponse, actualResponse);
    verify(securityService, times(1)).validateJwt(jwtToken, userId);
    verify(interactor, times(1)).createExpense(request);
}

}
