package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.edit.EditExpenseInteractor;
import com.splitscale.reems.security.wrappers.expenses.edit.EditExpenseWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditExpenseWrapperTest {

    @Mock
    private EditExpenseInteractor interactor;

    private EditExpenseWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditExpenseWrapper(interactor);
    }

    @Test
    public void testEditExpense() throws IOException, GeneralSecurityException {
        // Arrange
        Expense expense = new Expense(null, null, null, null, null);

        // Act
        wrapper.edit(expense);

        // Assert
        verify(interactor, times(1)).editExpense(expense);
    }
}
