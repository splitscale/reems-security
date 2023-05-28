package com.splitscale.reems.history;

import com.splitscale.reems.history.edit.EditHistoryInteractor;
import com.splitscale.reems.wrappers.history.edit.EditHistoryWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class EditHistoryWrapperTest {

    @Mock
    private EditHistoryInteractor interactor;

    private EditHistoryWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new EditHistoryWrapper(interactor);
    }

    @Test
    public void testEditHistory() throws IOException, GeneralSecurityException {
        // Arrange
        History history = new History("123", "History 1", "History Body", null);

        // Act
        wrapper.edit(history);

        // Assert
        verify(interactor, times(1)).editHistory(history);
    }
}
