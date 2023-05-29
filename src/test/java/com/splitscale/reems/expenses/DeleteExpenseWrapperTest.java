package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.delete.DeleteExpenseInteractor;
import com.splitscale.reems.security.wrappers.expenses.delete.DeleteExpense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteExpenseWrapperTest {

    @Mock
    private DeleteExpenseInteractor interactor;

    private DeleteExpense wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteExpense(interactor);
    }

    @Test
    public void testDeleteExpense() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";

        // Act
        wrapper.delete(id);

        // Assert
        verify(interactor, times(1)).deleteExpense(id);
    }

    @Test
    public void testDeleteAllExpenses() throws IOException, GeneralSecurityException {
        // Act
        wrapper.deleteAll();

        // Assert
        verify(interactor, times(1)).deleteAllExpense();
    }
}
