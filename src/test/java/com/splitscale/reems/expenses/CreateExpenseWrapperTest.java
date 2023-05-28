package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.create.CreateExpenseInteractor;
import com.splitscale.reems.wrappers.expenses.create.CreateExpenseWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateExpenseWrapperTest {

    @Mock
    private CreateExpenseInteractor interactor;

    private CreateExpenseWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new CreateExpenseWrapper(interactor);
    }

    @Test
    public void testCreateExpense() throws IOException, GeneralSecurityException {
        // Arrange
        ExpenseRequest request = new ExpenseRequest(null);
        String expectedResponse = "Success";

        when(interactor.createExpense(request)).thenReturn(expectedResponse);

        // Act
        String actualResponse = wrapper.create(request);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(interactor, times(1)).createExpense(request);
    }
}
