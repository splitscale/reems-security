package com.splitscale.reems.history;

import com.splitscale.reems.history.delete.DeleteHistoryInteractor;
import com.splitscale.reems.wrappers.history.delete.DeleteHistoryWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteHistoryWrapperTest {

    @Mock
    private DeleteHistoryInteractor interactor;

    private DeleteHistoryWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new DeleteHistoryWrapper(interactor);
    }

    @Test
    public void testDeleteHistory() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "123";

        // Act
        wrapper.delete(id);

        // Assert
        verify(interactor, times(1)).deleteHistory(id);
    }

    @Test
    public void testDeleteAllHistory() throws IOException, GeneralSecurityException {
        // Act
        wrapper.deleteAll();

        // Assert
        verify(interactor, times(1)).deleteAllHistory();
    }
}
