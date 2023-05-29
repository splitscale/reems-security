package com.splitscale.reems.expenses;

import com.splitscale.reems.expenses.read.ReadExpenseInteractor;
import com.splitscale.reems.security.wrappers.expenses.read.ReadExpense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadExpenseWrapperTest {

    @Mock
    private ReadExpenseInteractor interactor;

    private ReadExpense wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadExpense(interactor);
    }

    @Test
    public void testGetExpenseById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";
        Expense expectedExpense = new Expense();

        when(interactor.getExpenseById(id)).thenReturn(expectedExpense);

        // Act
        Expense actualExpense = wrapper.getExpenseById(id);

        // Assert
        assertEquals(expectedExpense, actualExpense);
        verify(interactor, times(1)).getExpenseById(id);
    }
}
